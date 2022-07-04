package crackingTheCodingInterview.chapter2LinkedLists;

/*
Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 -> 1 -> 2. That is, 912.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4).That is,342 + 465.
Output: 7 -> 0 -> 8. That is, 807.

1 -> 2 -> 3-> 4) and (5-> 6-> 7)
 */
public class SumLists {

    public static void main(String[] args) {
        var six = new LinkedListNode(1);
        six.next = new LinkedListNode(2);
        six.next.next = new LinkedListNode(3);
        six.next.next.next = new LinkedListNode(4);

        var two = new LinkedListNode(5);
        two.next = new LinkedListNode(6);
        two.next.next = new LinkedListNode(7);

        var obj = new SumLists();
        LinkedListNode n = obj.addLists(six, two);
        // 9 -> 1 -> 2
        while(n != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }
        System.out.println();
        System.out.println(" ---------- ");
        LinkedListNode n1 = obj.addListsBetter(six, two);
        while(n1 != null) {
            System.out.print(n1.data + ", ");
            n1 = n1.next;
        }
    }
    static class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }
    LinkedListNode addListsBetter(LinkedListNode l1,
                                  LinkedListNode l2)
    {
        int len1 = length(l1);
        int len2=  length(l2);
        //Pad the shorter list with zeros
        if(len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        //Add lists
        PartialSum sum = addListsHelper(l1, l2);
        //If there was a carry value left over, insert
        //this at the front of the list, Otherwise, just return
        //the linkedList
        if(sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }
    private PartialSum addListsHelper(LinkedListNode l1,
                                      LinkedListNode l2) {
        if(l1 == null && l2 == null) {
            return new PartialSum();
        }
        //Add smaller digits recursively
        PartialSum sum = addListsHelper(l1.next, l2.next);
        //Add carry to current data
        int val = sum.carry + l1.data + l2.data;
        //Insert sum of current digits
        LinkedListNode full_result = insertBefore(sum.sum, val % 10);
        //Return sum so far and the carry value
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    //Helper function to insert node in the front of a Linked list
    private LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if(list != null) {
            node.next = list;
        }
        return node;
    }
    //Pad the list with zeros
    private LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for(int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }
    private int length(LinkedListNode l1) {
        int length = 0;
        while(l1 != null) {
            length++;
            l1 = l1.next;
        }
        return length;
    }


    //Other Approach
    public LinkedListNode addLists(LinkedListNode l1,
                                   LinkedListNode l2)
    {
        LinkedListNode dummyHead = new LinkedListNode(0);
        LinkedListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new LinkedListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new LinkedListNode(carry);
        }
        return dummyHead.next;
    }
}
