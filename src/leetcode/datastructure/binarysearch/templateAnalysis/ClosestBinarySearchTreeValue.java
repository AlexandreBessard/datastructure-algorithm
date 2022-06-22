package leetcode.datastructure.binarysearch.templateAnalysis;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1028/
public class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        four.left = two;
        four.left.left = one;
        four.left.right = three;
        four.right = five;
        System.out.println(new ClosestBinarySearchTreeValue().closestValue(four, 4.35));
    }

    /*
    Binary Search O(H) time.
    Time complexity: O(H) since here one goes from root down to a leaf.
    Space complexity: 0(1)
     */
    public int closestValue(TreeNode root, double target) {
        int val; TreeNode current = root;
        int closest = current.value;
        while(current != null) {
            val = current.value;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            current =  target < current.value ? current.left : current.right;
        }
        return closest;
    }
}
