package leetcode.datastructure.binarytree.traverseatree;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> l = new LinkedList<>();

    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        three.left = new TreeNode(9);
        three.right = new TreeNode(20);
        three.right.left = new TreeNode(15);
        three.right.right = new TreeNode(7);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return l;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            List<Integer> lvl = new LinkedList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                l.get(level).add(curr.value);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            level++;
        }
        return l;
    }
}
