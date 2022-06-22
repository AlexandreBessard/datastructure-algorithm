package leetcode.datastructure.graph.breadthFirstSearch.excercices;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3895/
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        //Left side
        node1.left = node2;
        node1.left.left = node4;
        node1.left.right = node5;
        //right side
        node1.right = node3;
        node1.right.left = node6;
        node1.right.right = node7;
        //Output: [1,#,2,3,#,4,5,6,7,#]
        new PopulatingNextRightPointersInEachNode().connect(node1);
    }

    /*
    BFS: Approach 1: Level Order Traversal
    Time complexity: O(N) since we process each node.
    Space complexity: O(N) this is a perfect binary tree, depends the space occupied by
    the Q (BFS)
     */
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            int size = q.size();
            Node node = q.poll();
            for(int i = 0; i < size; i++) {
                if(i < size - 1) node.next = q.peek();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return root;
    }

    static class Node {
        int val;
        Node left, right, next;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.next = next;
        }
    }

}
