package leetcode.datastructure.recursion.recurrenceRelation;


public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        var two = new ListNode(2);
        var three = new ListNode(3);
        var four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        var result = new ReverseLinkedList()
                .reverseLinkedList(one);
        while(result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

    //Recursive approach
    public ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) return head;
        var node = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

}
