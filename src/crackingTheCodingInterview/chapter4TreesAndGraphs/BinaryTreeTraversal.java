package crackingTheCodingInterview.chapter4TreesAndGraphs;

public class BinaryTreeTraversal {

    private void visit(TreeNode node) {
        node.visited = true;
    }

    /*
    Post-order traversal visits the current node after its child nodes (hence the name "post-order").
     */
    public void postOrderTraversal(TreeNode node) {
        if(node != null) {
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
            visit(node);
        }
    }

    /*
    Pre-order traversal visits the current node before its child nodes (hence the name "pre-order").
     */
    public void preOrderTraversal(TreeNode node) {
        if(node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /*
    In-order traversal means to "visit" (often, print) the left branch, then the current node,
    and finally, the right branch.
     */
    public void inOrderTraversal(TreeNode node) {
        if(node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

}
