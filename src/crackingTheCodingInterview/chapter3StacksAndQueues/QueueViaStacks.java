package crackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/*
: Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueViaStacks {
    static class MyQueue<T> {
        Stack<T> stackNewest, stackOldest;
        public MyQueue() {
            stackNewest = new Stack<T>();
            stackOldest = new Stack<T>();
        }
        public int size() {
            return stackNewest.size() + stackOldest.size();
        }
        public void add(T value) {
            //Push onto newestStack, which always has the newest element on top
            stackNewest.push(value);
        }
        //Move element from newestStack into oldestStack
        private void shiftStacks() {
            if(stackOldest.isEmpty()) {
                while(!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }
        public T peek(){
            shiftStacks();
            return stackOldest.peek(); //Retrieve oldest item (it is a Queue)
        }

        public T remove() {
            shiftStacks(); //Ensure oldStack has the current element
            return stackOldest.pop();
        }
    }
}
