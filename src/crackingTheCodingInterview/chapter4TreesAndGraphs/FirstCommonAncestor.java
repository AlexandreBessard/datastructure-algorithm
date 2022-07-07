package crackingTheCodingInterview.chapter4TreesAndGraphs;

/*
First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
To Understand ancestor:
https://www.youtube.com/watch?v=py3R23aAPCA
 */
public class FirstCommonAncestor {

    public static void main(String[] args) {

    }

    //Solution 1: With Links to Parents
    /*
    Time complexity: O(d) where d is the depth of the deeper node
     */
    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q); // Get difference in depths
        TreeNode first = delta > 0 ? q : p; // Get shallower node
        TreeNode second = delta > 0 ? p : q; // Get the deeper node
        second = groupBy(second, Math.abs(delta)); //Move deeper node up
        //Find where paths intersect
        while(first != second
                && first != null
                && second != null)
        {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }
    private TreeNode groupBy(TreeNode node, int delta) {
        while(delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }
    private int depth(TreeNode node) {
        int depth = 0;
        while(node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
    //-------------------------------------------------------------------------------
    //Solution 2: With Links to Parents
    /*
    Time complexity: O(t) time where t is size of the subtree for the first common ancestor
     */
    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Check if either node is not in the tree or if one covers the other
        if(!covers(root, p) || !covers(root, q)) {
            return null;
        } else if(covers(p, q)) {
            return p;
        } else if(covers(q, p)) {
            return q;
        }
        //Traverse upwards until find a node that covers q
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while(!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }
    private TreeNode getSibling(TreeNode node) {
        if(node == null || node.parent == null) {
            return null;
        }
        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
    private boolean covers(TreeNode root, TreeNode p) {
        if(root == null)
            return false;
        if(root == p)
            return true;
        return covers(root.left, p) || covers(root.right, p);
    }
    //--------------------------------------------------------------------
    //Solution 3 : Without Links to Parents
    /*
    Time complexity: O(n)
     */
    private TreeNode commonAncestorWithoutParent(TreeNode root,
                                                  TreeNode p,
                                                  TreeNode q)
    {
        //Error check one node is not in the tree
        if(!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }
    private TreeNode ancestorHelper(TreeNode root,
                                     TreeNode p,
                                     TreeNode q)
    {
        if(root == null || root == p || root == q) {
            return root;
        }
        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);
        if(pIsOnLeft != qIsOnLeft) {
            return root; // Nodes are on different side
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }
    //--------------------------------------------------------------
    //Solution 4 : Optimized
    TreeNode commonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncHelper(root, p, q);
        if(r.isAncestor) {
            return r.node;
        }
        return null;
    }
    private Result commonAncHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return new Result(null, false);
        if(root == p && root == q)
            return new Result(root, true);
        Result rx = commonAncHelper(root.left, p, q);
        if(rx.isAncestor) { //Find common ancestor
            return rx;
        }
        Result ry = commonAncHelper(root.right, p, q);
        if(ry.isAncestor) { //Find common ancestor
            return ry;
        }
        if(rx.node != null && ry.node != null) {
            return new Result(root, true); //This is the common ancestor
        } else if(root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        }else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    static class Result {
        TreeNode node;
        boolean isAncestor;
        Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }
}
