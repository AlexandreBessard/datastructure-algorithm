package crackingTheCodingInterview.chapter2LinkedLists;

/*
Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list,
given only access to that node.
EXAMPLE
Input:the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b->d->e->f
 */
public class DeleteMiddleNode {

    public static void main(String[] args) {
        LinkedListNode one = new LinkedListNode(1);
        one.next = new LinkedListNode(2);
        one.next.next = new LinkedListNode(1);
        one.next.next.next = new LinkedListNode(3);
        var obj = new DeleteMiddleNode();
        obj.deleteNode(one);
    }
    public boolean deleteNode(LinkedListNode n) {
        if(n == null || n.next == null) {
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
