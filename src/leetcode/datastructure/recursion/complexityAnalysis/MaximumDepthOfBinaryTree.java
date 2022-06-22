package leetcode.datastructure.recursion.complexityAnalysis;

import com.sun.source.tree.Tree;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        var nine = new TreeNode(9);
        var twenty = new TreeNode(20);
        var fifteen = new TreeNode(15);
        var seven = new TreeNode(7);
        three.left = nine;
        three.right = twenty;
        three.right.left = fifteen;
        three.right.right = seven;
        System.out.println(new MaximumDepthOfBinaryTree()
                .maxDepth(three));
    }

    /*
    Recursion
    Time complexity O(n): we visit each node exactly once.
    Space complexity: Tree balanced; the height of the tree would be log(N)
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
