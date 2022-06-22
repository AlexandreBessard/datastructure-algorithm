package amazon.treesandgraphs;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/514/
public class ValidateBinarySearchTree {

    /*
    Time complexity: O(N) since we visit each node exactly once
    Space complexity: O(N) since we keep up the entire tree
     */
    public static void main(String[] args) {
        TreeNode three = new TreeNode(2);
        three.left = new TreeNode(1);
        three.right = new TreeNode(3);

        TreeNode five = new TreeNode(5);
        five.left = new TreeNode(2);
        five.left.left = new TreeNode(1);
        five.left.right = new TreeNode(5);
        five.right = new TreeNode(6);
        System.out.println(isValidBST(five));
    }

    public static boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null) return true;
        if(high != null && high <= root.value || low != null && low >= root.value)
            return false;
        return validate(root.left, low, root.value) && validate(root.right, root.value, high);
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

}
