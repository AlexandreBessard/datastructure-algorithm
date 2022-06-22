package tests.collection;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek()); // get 3
        System.out.println(stack.pop()); //remove 3
        System.out.println(stack.pop()); // remove 2

        /*
        Both pop() and peek() throw an EmptyStackException if the stack contains no elements.
         */

    }

}
