package tests.collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//https://www.happycoders.eu/java/queue-deque-stack-ultimate-guide/
public class QueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);


        //Printed in FIFO order.
        System.out.println(queue);
        System.out.println(queue.peek()); // get 1
        System.out.println("poll :" + queue.poll()); //return null, remove 1
        System.out.println("Should be 2 ==> " + queue.peek());
        //queue.remove() -> NoSuchElementException is queue is null
        System.out.println(queue);




    }

}
