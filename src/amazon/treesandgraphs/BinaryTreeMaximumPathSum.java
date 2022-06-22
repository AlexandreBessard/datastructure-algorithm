package amazon.treesandgraphs;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2981/
public class BinaryTreeMaximumPathSum {

    static int MAX_SUM = Integer.MIN_VALUE;

    /*
    Time complexity: O(N) we visit each node not more than 2 times.
    Space complexity: O(H) where H is the tree height to keep the recursion stack.
     */
    public static void main(String[] args) {

        TreeNode minus_ten = new TreeNode(10);
        minus_ten.left = new TreeNode(9);
        minus_ten.right = new TreeNode(20);
        minus_ten.right.left = new TreeNode(15);
        minus_ten.right.right = new TreeNode(7);
        System.out.println(maxPath(minus_ten));
    }

    public static int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.value + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        MAX_SUM = Math.max(MAX_SUM, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        /*
        Use this line of code because:
        You want to record the value if it did not split, and compare it to result.
        However, you want to return the value of the "if-split" condition to the parent node.
        Because, if you return the "don't split" condition to the parent node,
        it'll not be a valid path.
         */
        return node.value + Math.max(left_gain, right_gain);
    }

    public static int maxPath(TreeNode root) {
        max_gain(root);
        return MAX_SUM;
    }


}
