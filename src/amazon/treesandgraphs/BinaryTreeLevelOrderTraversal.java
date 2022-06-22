package amazon.treesandgraphs;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/506/
/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).


Time complexity: O(N) since each node is process exactly once.
Space complexity: O(N) to keep the output structure which contains N node values.
 */
public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levels = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        three.left = new TreeNode(9);
        three.right = new TreeNode(20);
        three.right.left = new TreeNode(15);
        three.right.right = new TreeNode(7);
        new BinaryTreeLevelOrderTraversal().levelOrder(three);
    }


    private void helper(TreeNode node, int lvl) {
        if(levels.size() == lvl) {
            levels.add(new ArrayList<>());
        }
        levels.get(lvl).add(node.value);
        if(node.left != null) {
            helper(node.left, lvl + 1);
        }
        if(node.right != null) {
            helper(node.right, lvl + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        helper(root, 0);
        return levels;
    }

}
