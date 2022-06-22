package leetcode.datastructure.recursion.principleOfRecursion.excercices;

//https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
public class SwapNodeInPairs {


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        int[] nums = {1,2,3,4};
        //Output: {2, 1, 4, 3}
        var nodes = new SwapNodeInPairs().swapPairs(one);
        while(nodes != null) {
            System.out.print(nodes.val);
            nodes = nodes.next;
        }
    }

    //Recursive approach
    /*
    Time complexity O(N) where N is the size of LinkedList
    Space complexity O(N) stack space utilized for recursion
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        var firtNode = head;
        var secondNode = head.next;
        firtNode.next = swapPairs(secondNode.next);
        secondNode.next = firtNode;
        return secondNode;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

}
