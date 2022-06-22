package amazon.treesandgraphs;

import amazon.treesandgraphs.utils.TreeNode;
//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/507/
public class SymmetricTree {
    /*
    Time complexity: O(N): we traverse the entire input tree once.
    Space complexity: O(N): Recursive calls on the stack is O(N) bound by the height of the tree.
     */
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.left.left = new TreeNode(3);
        one.left.right = new TreeNode(4);
        one.right = new TreeNode(2);
        one.right.left = new TreeNode(4);
        one.right.right = new TreeNode(3);
        System.out.println(isSymetric(one));
    }

    public static boolean isSymetric(TreeNode node) {
        return isMirror(node, node);
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.value != node2.value) return false;
        return
                isMirror(node1.left, node2.right)
                &&
                isMirror(node1.right, node2.left);
    }
}
