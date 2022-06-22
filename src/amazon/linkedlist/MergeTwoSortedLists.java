package amazon.linkedlist;

//https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode listOne = new ListNode(1);
        listOne.next = new ListNode(2);
        listOne.next.next = new ListNode(4);

        ListNode listTwo = new ListNode(1);
        listTwo.next = new ListNode(3);
        listTwo.next.next = new ListNode(4);

        ListNode n = new MergeTwoSortedLists().mergeTwoLists(listOne, listTwo);
        while(n != null) {
            System.out.print(n.val + ", ");
            n = n.next;
        }
    }

    /*
    Iteration
    Time complexity: O(n + m)
    exactly one of l1 and l2 is incremented on each loop iteration.
    Space complexity: O(1)
    The iterative approach only allocates a few pointers.
    Constant overall memory footprint.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(- 1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
