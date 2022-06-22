package leetcode.datastructure.graph.breadthFirstSearch.excercices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3897/
public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        //1,null,3,2,4,null,5,6

    }

    /*
    Breadth-first Search using a Queue
    Time complexity: O(N) where N is the number of nodes
    Space complexity: O(N)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.val);
                q.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
