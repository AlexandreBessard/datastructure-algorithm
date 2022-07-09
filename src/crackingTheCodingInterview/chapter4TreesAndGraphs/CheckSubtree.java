package crackingTheCodingInterview.chapter4TreesAndGraphs;

/*
Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine ifT2 is a subtree of Tl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
That is, if you cut off the tree at node n, the two trees would be identical
 */
public class CheckSubtree {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        one.left.left = new TreeNode(4);

        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(4);

        var obj = new CheckSubtree();
        obj.containsTreeOptimized(one, two);
    }

    /*
    Optimized approach
    Space complexity: O(log(n) + log(m)) memory
    Time complexity: O(nm)
     */
    public boolean containsTreeOptimized(TreeNode t1, TreeNode t2) {
        if(t2 == null)
            return true; // Empty tree is always a subtree
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode r1, TreeNode r2) {
        if(r1 == null)
            return false;
        else if(r1.value == r2.value && matchTree(r1, r2)) {
            return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }
    private boolean matchTree(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return true; // nothing left in the subtree
        } else if(r1 == null || r2 == null) {
            return false; // exactly tree is empty, therefore trees don't match
        } else if(r1.value != r2.value) {
            return false; // data does not match
        } else {
            return matchTree(r1.left, r2.left)
                    && matchTree(r1.right, r2.right);
        }
    }


    /*
    Time complexity:
    O(n + m) where n and m are the number of nodes in T1 and T2 respectively.
    Space complexity:
    O(n + m)
     */
    public boolean containsTree(TreeNode t1, TreeNode t2) {
        var string1 = new StringBuilder();
        var string2 = new StringBuilder();
        getOrderString(t1, string1);
        getOrderString(t2, string2);
        return string1.indexOf(string2.toString()) != -1; //-1 if substring is not present
    }

    private void getOrderString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("X"); // Add null indicator
            return;
        }
        sb.append(node.value + " "); //Add root
        getOrderString(node.left, sb); // Add left
        getOrderString(node.right, sb); // Add right
    }

}
