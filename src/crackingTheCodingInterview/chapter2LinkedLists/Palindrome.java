package crackingTheCodingInterview.chapter2LinkedLists;

import java.util.Stack;

//: Implement a function to check if a linked list is a palindrome.
public class Palindrome {

    public static void main(String[] args) {
        LinkedListNode zero = new LinkedListNode(0);
        zero.next = new LinkedListNode(1);
        zero.next.next = new LinkedListNode(2);
        zero.next.next.next = new LinkedListNode(1);
        zero.next.next.next.next = new LinkedListNode(0);

        var obj = new Palindrome();
        System.out.println(obj.isPalindrome(zero));
        System.out.println(obj.isPalindromeIterative(zero));
        System.out.println(obj.isPalindromeRecursiveApproach(zero));
    }

    /*
    Recursive approach
     */
    static class Result {
        LinkedListNode node;
        boolean result;
        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }
    public boolean isPalindromeRecursiveApproach(LinkedListNode head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }
    private Result isPalindromeRecurse(LinkedListNode head, int length) {
        if(head == null || length <= 0) // Even number of nodes
            return new Result(head, true);
        else if (length == 1) //Odd number of nodes
            return new Result(head.next, true);
        //Recurse on sublist
        Result res = isPalindromeRecurse(head.next, length - 2);
        //If child calls are not palindrome, pass back up a
        if(!res.result || res.node == null) {
            return res;
        }
        //Check if matches corresponding node on other side
        res.result = (head.data == res.node.data);
        //Return corresponding node
        res.node = res.node.next;
        return res;
    }
    private int lengthOfList(LinkedListNode n) {
        int size = 0;
        while(n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    /*
    Iterative approach
     */
    public boolean isPalindromeIterative(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        //Has odd number of elements, so skip the middle element
        if(fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            int top = stack.pop();
            //f values different, then it is not palindrome
            if(top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    /*
    ------------------------
     */
    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }
    private boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while(one != null && two != null) {
            if(one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }
    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while(node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }


}
