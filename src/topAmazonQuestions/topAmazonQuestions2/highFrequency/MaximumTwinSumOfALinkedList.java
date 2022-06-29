package topAmazonQuestions.topAmazonQuestions2.highFrequency;

//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        ListNode four = new ListNode(4);
        four.next = new ListNode(2);
        four.next.next = new ListNode(2);
        four.next.next.next = new ListNode(3);
        var obj = new MaximumTwinSumOfALinkedList();
        System.out.println(obj.pairSum(four));
    }

    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        ListNode curr = head;
        ListNode secondHead = getSecondHalf(curr);
        ListNode reverseSecondHead = reverseSecondHalf(secondHead);
        while(reverseSecondHead != null) {
            max = Math.max(max, head.val + reverseSecondHead.val);
            head = head.next;
            reverseSecondHead = reverseSecondHead.next;
        }
        return max;
    }
    private ListNode reverseSecondHalf(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    private ListNode getSecondHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
