package leetcode.datastructure.binarytree.solveproblemrecursively;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        three.left = nine;
        three.right = twenty;
        three.right.left = fifteen;
        three.right.right = seven;

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(three, 0));
    }

    public int maxDepth(TreeNode root, int depth) {
        if(root == null) return 0;
        int left = maxDepth(root.left, depth);
        int right = maxDepth(root.right, depth);
        return Math.max(left, right) + 1;
    }

}
