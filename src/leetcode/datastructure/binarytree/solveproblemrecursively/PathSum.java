package leetcode.datastructure.binarytree.solveproblemrecursively;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.LinkedList;

//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
public class PathSum {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.left = two;
        one.right = three;

        System.out.println(new PathSum().hasPathSum(one, 3));

    }

    /*
    Time complexity: visit each node once: O(N) N is number of nodes
    Space complexity: unbalanced (worst case) O(N)
    Best case: tree balanced O(log(N))
     */
    //Recursive approach
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        //Decrease value
        sum -= root.value;
        //If leaf
        if(root.left == null && root.right == null) return (sum == 0);
        //continue
        //if both conditions are false then the condition becomes false.
        //if one is true and other one false ==> return true
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //Iterative approach
    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if(root == null) return false;
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(sum - root.value);
        TreeNode node;
        int curr_sum;
        while(!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if(node.left == null && node.right == null && curr_sum == 0) return true;
            if(node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(sum - node.right.value);
            }
            if(node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(sum - node.left.value);
            }
        }
        return false;
    }
}
