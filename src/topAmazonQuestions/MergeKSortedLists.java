package topAmazonQuestions;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {

    public static void main(String[] args) {
        var one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(5);
        var one1 = new ListNode(1);
        one1.next = new ListNode(3);
        one1.next.next = new ListNode(4);
        var two = new ListNode(2);
        two.next = new ListNode(6);
        //Testing
        var one2 = new ListNode(1);
        one2.next = new ListNode(5);
        var one3 = new ListNode(3);
        one3.next = new ListNode(9);
        var one4 = new ListNode(4);
        one4.next = new ListNode(3);

        //ListNode[] lists = {one, one1, two};
        ListNode[] lists = {one, one1, two, one2, one3, one4};
        var obj = new MergeKSortedLists();
        ListNode n = obj.mergeKLists(lists);
        while(n != null) {
            System.out.print(n.val + ",");
            n = n.next;
        }
    }
    /*
    Approach 5: Divide and conquer
    Time complexity: O(N log K) where k is the number of linkedList
    O(n) where n is the total number of nodes in two lists.
    Sum up the merge process: O(N log k)

    Time complexity: O(1)
    We can merge two sorted linked list in O(1) space.
     */
    private ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        int interval = 1;
        while(interval<lists.length){
            for (int i = 0; (i + interval) < lists.length; i=i+interval*2) {
                System.out.println(i + " " + (i + interval) + " => " + (i+interval*2));
                lists[i]=mergeTwoList(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
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
        return ans.next;
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
