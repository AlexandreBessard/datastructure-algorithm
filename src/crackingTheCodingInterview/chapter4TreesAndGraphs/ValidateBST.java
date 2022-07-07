package crackingTheCodingInterview.chapter4TreesAndGraphs;

/*
Implement a function to check if a binary tree is a binary search tree.
 */
public class ValidateBST {

    public static void main(String[] args) {

    }

    /*
    Time complexity: O(N) where N is the number of nodes in the tree.
    Space complexity: O(log N) recursive calls on the stack.
     */
    public boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }
    private boolean checkBST(TreeNode n, Integer min, Integer max) {
        if(n == null)
            return true;
        if(min != null && n.value <= min
                || max != null && n.value > max) {
            return false;
        }
        if(!checkBST(n.left, min, n.value)
                || !checkBST(n.right, n.value, max)) {
            return false;
        }
        return true;
    }
}
