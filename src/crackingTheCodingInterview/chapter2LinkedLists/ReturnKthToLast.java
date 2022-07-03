package crackingTheCodingInterview.chapter2LinkedLists;

/*
Implement an algorithm to find the kth to last element of a singly linked list
 */
public class ReturnKthToLast {

    public static void main(String[] args) {
        LinkedListNode one = new LinkedListNode(1);
        one.next = new LinkedListNode(2);
        one.next.next = new LinkedListNode(1);
        one.next.next.next = new LinkedListNode(3);
        var obj = new ReturnKthToLast();
        System.out.println(obj.printKthToLast(one, 1));
        System.out.println(obj.printKthToLastIterative(one, 1));

    }

    /*
    Iterative
     */
    public LinkedListNode printKthToLastIterative(LinkedListNode head,
                                       int k)
    {
        var p1 = head;
        var p2 = head;
        //Move p1 k nodes into the list
        for(int i = 0; i < k; i++) {
            if(p1 == null) return null; //Out of bonds
            p1 = p1.next;
        }
        //Move them at the same pace. When p1 hits the end, p2
        //will be at the right element
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    /*
    Recursive approach
    Keep in mind, start from last
     */
    public int printKthToLast(LinkedListNode head, int k) {
        if(head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if(index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }
}
