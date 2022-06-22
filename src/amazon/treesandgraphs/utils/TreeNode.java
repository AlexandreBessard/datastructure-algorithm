package amazon.treesandgraphs.utils;

public class TreeNode {

    public TreeNode left, right;
    public int value;
    public TreeNode(int value){
        this.value = value;
    }
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

}
