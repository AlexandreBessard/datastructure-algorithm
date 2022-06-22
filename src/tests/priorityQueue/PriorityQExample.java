package tests.priorityQueue;

import java.util.PriorityQueue;

public class PriorityQExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> testIntegersPQ = new PriorityQueue<>((n1, n2) -> n1 - n2);

        testIntegersPQ.add(11);
        testIntegersPQ.add(5);
        testIntegersPQ.add(-1);
        testIntegersPQ.add(12);
        testIntegersPQ.add(6);
        testIntegersPQ.add(10);

        System.out.println(" => " + testIntegersPQ);

        System.out.println("Integers stored in reverse order of priority in a Priority Queue\n");
        while (!testIntegersPQ.isEmpty()) {
            System.out.println(testIntegersPQ.poll());
        }
    }

}
