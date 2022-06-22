package leetcode.datastructure.binarytree.traverseatree;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Left -> Node (root) -> Right
 */
public class BinaryTreeInorderTraversal {

    /*
    Time complexity: O(N) because it is a recursive function
    Space complexity: O(N) the worst space required
     */
    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        one.right.left = three;

        System.out.println(new BinaryTreeInorderTraversal()
                .inorderTraversal(one));
    }

    private void helper(TreeNode node, List<Integer> l) {
        if(node != null) {
            helper(node.left, l);
            l.add(node.value);
            helper(node.right, l);
        }
    }

    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> l = new ArrayList<>();
        helper(node, l);
        return l;
    }

}
