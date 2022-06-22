package tests.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {
        Deque<Integer> dequeue = new ArrayDeque<>();
        dequeue.offerFirst(20); // -> 20
        dequeue.offerFirst(21); // -> 21 20
        dequeue.offerFirst(22); // -> 22 21 20
        /*
        dequeue.offerLast(23);  // -> 22 21 20 23
        dequeue.offerLast(24);  // -> 22 21 20 23 24
        dequeue.offerLast(25);  // -> 22 21 20 23 24 25
        dequeue.offerFirst(26); // -> 26 22 21 20 23 24 25
        dequeue.offerFirst(27); // -> 27 26 22 21 20 23 24 25

         */
        System.out.println("dequeue = " + dequeue);

        System.out.println();
        System.out.println("dequeue.offerLast(28) = " + dequeue.offerLast(28));
        //System.out.println("dequeue.offerFirst(29) = " + dequeue.offerFirst(29));
        System.out.println("dequeue = " + dequeue);

        System.out.println("Removing elements: ");
        //Retrieve and remove first element
        System.out.println(dequeue.pollFirst());
        //Retrieve but does not remove the last element
        System.out.println(dequeue.peekLast());
        System.out.println("peek => " + dequeue.peek());

    }

}
