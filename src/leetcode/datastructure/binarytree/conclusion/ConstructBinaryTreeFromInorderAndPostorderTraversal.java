package leetcode.datastructure.binarytree.conclusion;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        System.out.println(new ConstructBinaryTreeFromInorderAndPostorderTraversal()
                .buildTree(inorder, postorder));

    }


    int[] postorder;
    int[] inorder;
    int post_idx;
    Map<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        //Start from the last postOrder element (root)
        post_idx = postorder.length - 1;
        //Build  hashMap value -> its index
        int idx = 0;
        for(Integer val: inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int int_left, int int_right) {
        //If there is no elements to construct subtrees
        if(int_left > int_right) {
            return null;
        }
        //Pick up post_idx element as a root
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        //root split inorder list into left and right subtrees
        int index = idx_map.get(root_val);
        post_idx--;
        //build right subtree
        root.right = helper(index + 1, int_right);
        //build left subtree
        root.left = helper(int_left, index - 1);
        return root;
    }

}
