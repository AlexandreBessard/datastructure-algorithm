package leetcode.datastructure.binarytree.traverseatree;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.LinkedList;

public class BinaryTreePreorderTraversal {
    final LinkedList<Integer> l = new LinkedList<>();
    //https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/
    /*
    Pre-order traversal is to visit the root first. Then traverse the left subtree.
    Finally, traverse the right subtree.
    ----------------------
    Node -> Left -> Right
    */
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        one.right.left = three;
        System.out.println(
                new BinaryTreePreorderTraversal().preorderTraversal(one)
        );
    }

    public LinkedList<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return l;
        l.add(root.value);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return l;
    }
}
