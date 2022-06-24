package tests.topQuestionsTest;

import topAmazonQuestions.MergeKSortedLists;

public class MergeKSortedListTest {

    public static void main(String[] args) {
        var one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(5);
        var one1 = new ListNode(1);
        one1.next = new ListNode(3);
        one1.next.next = new ListNode(4);
        var two = new ListNode(2);
        two.next = new ListNode(6);
        ListNode[] list = {one, one1, two};
        ListNode n = new MergeKSortedListTest().mergeKLists(list);
        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }


    /*
    Divide and conquer
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int interval = 1;
        while(interval < lists.length) {
            for(int i = 0; (i + interval) < lists.length; i=i+interval*2) {
                lists[i] = mergeTwoLinkedList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode h = result;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) h.next = l2;
        if(l2 == null) h.next = l1;
        return result.next;
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
