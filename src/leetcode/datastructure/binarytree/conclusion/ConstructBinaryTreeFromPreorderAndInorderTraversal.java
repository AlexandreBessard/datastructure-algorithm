package leetcode.datastructure.binarytree.conclusion;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode n = new ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(preorder, inorder);
    }

    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        int val = preorder[preorderIndex++];
        TreeNode n = new TreeNode(val);
        n.left = arrayToTree(preorder, left, inorderIndexMap.get(val) - 1);
        n.right = arrayToTree(preorder, inorderIndexMap.get(val) + 1, right);
        return n;
    }

}
