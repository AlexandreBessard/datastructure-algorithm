package tests.list;

import java.util.Iterator;
import java.util.LinkedList;
/*
Pros of using LinkedList:
Linked list allows dynamic memory allocation,
which means memory allocation is done at the run time by the compiler
 and we do not need to mention the size of the list during linked list declaration.

 Linked list elements don’t need contiguous memory locations because elements are linked
 with each other using
 the reference part of the node that contains the address of the next node of the list.

Insert and delete operations in the Linked list are not performance wise expensive because adding
and deleting an element from the linked list does not require element shifting,
only the pointer of the previous and the next node requires change.
 */
public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");

        list.addFirst("Negan");
        list.addLast("Rick");

        list.add(2, "Glenn");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(" ");
            System.out.print(it.next());
        }


        System.out.println();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1); // 1
        linkedList.add(2); // 1 -> 2
        Iterator<Integer> it1 = linkedList.iterator();
        while(it1.hasNext()) {
            System.out.print(it1.next());
            System.out.print(", ");
        }
        System.out.println();
        System.out.println(linkedList.peekLast());

    }

}
