package amazon.treesandgraphs;

import amazon.treesandgraphs.utils.TreeNode;
import com.sun.source.tree.Tree;

public class DiameterOfBinaryTree {

    int diameter = 0;

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.left.left = four;
        one.left.right = five;
        one.right = three;
        System.out.println(
                new DiameterOfBinaryTree().diameterOfBinaryTree(one)
        );
    }

    private int longestPath(TreeNode node) {
        if(node == null) return 0;
        int left = longestPath(node.left);
        int right = longestPath(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

}
