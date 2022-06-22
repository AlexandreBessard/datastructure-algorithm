package leetcode.datastructure.binarytree.conclusion;

import leetcode.datastructure.binarytree.util.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.left = two;
        one.right = three;
        one.left.left = four;
        one.left.right = five;
        one.right.left = six;
        one.right.right = seven;
        new PopulatingNextRightPointersInEachNode()
                .connect(one);
    }

    //Level order Traversal
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (i < size - 1) n.next = q.peek();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return root;
    }
}
