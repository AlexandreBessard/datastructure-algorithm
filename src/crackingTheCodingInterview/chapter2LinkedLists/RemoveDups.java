package crackingTheCodingInterview.chapter2LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
R􀂧mov􀂧 Dups!
Write code to remove duplicates from an unsorted linked list.
 */
public class RemoveDups {

    public static void main(String[] args) {
        LinkedListNode one = new LinkedListNode(1);
        one.next = new LinkedListNode(2);
        one.next.next = new LinkedListNode(1);
        one.next.next.next = new LinkedListNode(3);
        var obj = new RemoveDups();
        obj.deleteDupsNoBufferAllowed(one);
        LinkedListNode n = one;
        while(n != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }
    }

    public void deleteDupsNoBufferAllowed(LinkedListNode head) {
        LinkedListNode current = head;
        while(current != null) {
            //Remove all future nodes that have the same value
            LinkedListNode runner = current;
            while(runner.next != null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //Remove duplicate from linkedList
    /*
    Time complexity: O(N) where N is the number of elements in the linked list.
     */
    public void deleteDups(LinkedListNode n) {
        Set<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while(n != null) {
            if(set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}
