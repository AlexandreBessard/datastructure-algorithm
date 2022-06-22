package leetcode.datastructure.binarytree.solveproblemrecursively;

import amazon.treesandgraphs.utils.TreeNode;

public class BottomUpSolution {

    public static void main(String[] args) {

    }

    public int max_depth(TreeNode root) {
        if(root == null) return 0;
        int left = max_depth(root.left);
        int right = max_depth(root.right);
        return Math.max(left, right) + 1;
    }

}
