package leetcode.datastructure.binarytree.traverseatree;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/1036/
Bottom -> Top
Left -> Right
---------------
Bottom left -> right -> root node
 */
public class BinaryTreePostOrderTraversal {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        one.right.left = three;
        System.out.println(new BinaryTreePostOrderTraversal()
                .postorderTraversal(one));

    }

    private void helper(TreeNode n, List<Integer> l) {
        if(n == null) return;
        helper(n.left, l);
        helper(n.right, l);
        l.add(n.value);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l  = new ArrayList<>();
        helper(root, l);
        return l;
    }

}
