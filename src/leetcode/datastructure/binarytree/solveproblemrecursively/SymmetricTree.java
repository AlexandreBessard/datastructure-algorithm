package leetcode.datastructure.binarytree.solveproblemrecursively;

import amazon.treesandgraphs.utils.TreeNode;
import com.sun.security.jgss.GSSUtil;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode two1 = new TreeNode(2);

        TreeNode three = new TreeNode(3);
        TreeNode three1 = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four1 = new TreeNode(4);

        one.left = two;
        one.right = two1;

        one.left.left = three;
        one.right.right = three1;

        one.right.left = four;
        one.left.right = four1;

        System.out.println(new SymmetricTree
                .SymmetricTreeIterative()
                .isSymmetric(one));
    }

    static class statiSymmetricTreeRecursive {
        /*
        Time complexity: O(N) because we traverse the entire input tree once. n total of nodes.
        Space complexity: O(N) number of recursive calls is bound by the height of the tree.
         */
        //Recursive approach
        private boolean isMirror(TreeNode node1, TreeNode node2) {
            if(node1 == null && node2 == null) return true;
            if(node1 == null || node2 == null) return false;
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }
    }

    static class SymmetricTreeIterative {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(root);
            while (!q.isEmpty()) {
                System.out.println();
                for(TreeNode n : q) {
                    System.out.print(n.value);
                }
                TreeNode t1 = q.poll();
                TreeNode t2 = q.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.value != t2.value) return false;
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
            return true;
        }
    }
}
