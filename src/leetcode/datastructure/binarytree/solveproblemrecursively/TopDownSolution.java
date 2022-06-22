package leetcode.datastructure.binarytree.solveproblemrecursively;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/534/
public class TopDownSolution {


    int answer = 0;

    public static void main(String[] args) {

    }


    public void maximum_depth(TreeNode node, int depth) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(node.left, depth + 1);
        maximum_depth(node.right, depth + 1);
    }
}
