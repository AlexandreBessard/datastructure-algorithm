package leetcode.datastructure.binarytree.conclusion;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
public class LowestCommonAncestorOfABinaryTree {

    private TreeNode ans = null;

    /*
    Time complexity: O(N) visit all nodes of the binaryTree.
    Space complexity: O(N) is the maximum amount of space utilized by the recursion stack.
     */
    public static void main(String[] args) {

    }

    public boolean helper(TreeNode n, TreeNode p, TreeNode q) {
        if(n == null) return false;
        int left = helper(n.left, p, q) ? 1 : 0;
        int right = helper(n.right, p, q) ? 1 : 0;
        int mid = (n == p || n == q) ? 1 : 0;
        if( left + right + mid >= 2) this.ans = ans;
        return (left + right + mid > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.helper(root, p, q);
        return ans;
    }
}
