package crackingTheCodingInterview.chapter2LinkedLists;

public class LinkedListNode {
    LinkedListNode next = null;
    int data;
    public LinkedListNode() {}
    public LinkedListNode(int d) {
        data = d;
    }
    void appendToTail(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
    void setNext(LinkedListNode node) {
        this.next = node;
    }
}
