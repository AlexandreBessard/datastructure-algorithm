package leetcode.datastructure.binarytree.util;

public class Node {
    public int val;
    public Node left, right, next;
    public Node(){}
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.next = next;
    }
}
