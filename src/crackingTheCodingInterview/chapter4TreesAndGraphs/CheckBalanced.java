package crackingTheCodingInterview.chapter4TreesAndGraphs;

/*
Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
 */
public class CheckBalanced {

    public static void main(String[] args) {
        var obj = new CheckBalanced();
        System.out.println(obj.isBalanced(new TreeNode(1)));
        System.out.println(obj.isBalancedOptimized(new TreeNode(1)));

    }

    public boolean isBalancedOptimized(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
    private int checkHeight(TreeNode root) {
        if(root == null)
            return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Pass error up
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Pass error up
        if(Math.abs(leftHeight) > 1)
            return Integer.MIN_VALUE; // Found error
        else
            return Math.max(leftHeight, rightHeight) + 1;

    }

    /*
    Time complexity: O(N log N)
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)  //Base case
            return true;
        int heightDiff = getHeight(root.left);
        if(Math.abs(heightDiff) > 1) {
            return false;
        } else { //Recurse
            return isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    private int getHeight(TreeNode root) {
        if(root == null)
            return -1; // Base case
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
