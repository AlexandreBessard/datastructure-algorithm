package amazon.linkedlist;

import amazon.linkedlist.util.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode result = new AddTwoNumbers().addTwoNumbers(node, node2);

        while (result != null) {
            System.out.print(result.val);
            System.out.print(", ");
            result = result.next;
        }
    }

    /*
    Time complexity: O(max(m, n)). Assume that 'm' and 'n' represents the length of l1 and l2.
    Iterates at most max(m, n)
    Space complexity: O(max(m, n)). The length of the new list is at most max(m, n) + 1.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
