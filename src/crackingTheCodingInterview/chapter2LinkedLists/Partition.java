package crackingTheCodingInterview.chapter2LinkedLists;

/*
Partition: Write code to partition a linked list around a value x, such that all nodes less
than x come before all nodes greater than or equal to x.
If x is contained within the list the values of x only need
to be after the elements less than x (see below).
The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {

    /*
    x value, all nodes less than x come BEFORE all nodes greater than or equal to x.
     */
    public static void main(String[] args) {
        var two = new LinkedListNode(2);
        two.next = new LinkedListNode(3);
        two.next.next = new LinkedListNode(5);
        var obj = new Partition();
        LinkedListNode n = obj.paritionOptimized(two, 5);
        while(n != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }
    }

    public LinkedListNode paritionOptimized(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;
        while(node != null) {
            LinkedListNode next = node.next;
            if(node.data < x) {
                //Insert node at head
                node.next = head;
                head = node;
            } else {
                //Insert node at tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        //The head has changed, we need to return it to the user.
        return head;
    }

    public LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;
        //Partition List
        while(node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if(node.data < x) { //Come before
                //Insert node into the end of beforeList
                if(beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                //Insert node into end of afterList
                if(afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        if(beforeStart == null) {
            return afterStart;
        }
        //Merge before list and after list
        beforeEnd.next = afterStart;
        return beforeStart;
    }



}
