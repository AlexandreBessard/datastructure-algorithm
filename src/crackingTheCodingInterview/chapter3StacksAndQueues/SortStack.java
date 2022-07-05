package crackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/*
Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 */
public class SortStack {
    public static void main(String[] args) {}
    /*
    Time complexity: O(N²)
    Space complexity: O(N)
     */
    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while(!s.isEmpty()) {
            //Insert each element in s in sorted order into r
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        //Copy element from r back into s
        while(!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
