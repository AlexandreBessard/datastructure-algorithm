package leetcode.datastructure.recursion.recurrenceRelation;

//https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
public class SearchInABinarySearchTree {

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        var seven = new TreeNode(7);
        var two = new TreeNode(2);
        var one = new TreeNode(1);
        var three = new TreeNode(3);
        four.left = two;
        four.right = seven;
        four.left.left = one;
        four.left.right = three;
        System.out.println(new SearchInABinarySearchTree().searchBST(four, 2).val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        return val < root.val
                ? searchBST(root.left, val)
                : searchBST(root.right, val);
    }

        static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
