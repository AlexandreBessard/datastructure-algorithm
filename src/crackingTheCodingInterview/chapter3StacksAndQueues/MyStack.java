package crackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
        private StackNode<T> top;
        //Return the top of the stack
        public T peek(){
            if(top == null) throw new EmptyStackException();
            return top.data;
        }
        //Remove item from the list
        public T pop() {
            if(top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }
        //Add an item to the top of the stack
        public void push(T item) {
            StackNode<T> t = new StackNode<>(item);
            t.next = top;
            top = t;
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
}
