package amazon.treesandgraphs;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/
public class BinaryTreeZigzagLevelOrderTraversal {

    /*
    BFS Breadth-First-Search

    Time complexity: O(N) where N is the number of nodes in the tree.
    Visit each node only once.
    The insertion operation in the deque takes constant time. If we use array/List O(K) where
    K is the length of the list.

    Space complexity: O(N)
    The main memory consumption of the algorithm is the node_queue that we use for the loop,
    apart from the array that we use to keep the final output.
     */
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        three.left = new TreeNode(9);
        three.right = new TreeNode(20);
        three.right.left = new TreeNode(15);
        three.right.right = new TreeNode(7);
        System.out.println(
                new BinaryTreeZigzagLevelOrderTraversal()
                .zigzagLevelOrder(three)
        );
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> l = new LinkedList<>();
        if(node == null) return l;
        boolean even = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            int n = q.size();
            LinkedList<Integer> l2 = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
                if(even) l2.add(currNode.value);
                else l2.addFirst(currNode.value);
            }
            l.add(l2);
            even = !even;
        }
        return l;
    }

}
