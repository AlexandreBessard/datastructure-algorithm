package leetcode.datastructure.recursion.conclusion.excercices;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2384/
public class UniqueBinarySearchTreesII {
    
    public static void main(String[] args) {
        new UniqueBinarySearchTreesII().generateTrees(3);
        List<TreeNode> l = new UniqueBinarySearchTreesII()
                .generateTreesTest(3);
        for(TreeNode n : l) {
            System.out.print(n.val + ", ");
        }
    }

    public List<TreeNode> generateTreesTest(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_treesTest(1, n);
    }

    /*
    Recursion
     */
        public List<TreeNode> generate_treesTest(int start, int end) {
            List<TreeNode> liste = new LinkedList<>();
            if(start > end) {
                LinkedList<TreeNode> l = new LinkedList<>();
                l.add(null);
                return l;
            }
            for(int i = start; i <= end; i++) {
                List<TreeNode> left = generate_treesTest(start, i - 1);
                List<TreeNode> right = generate_treesTest(start + 1, end);
                for(TreeNode l : left){
                    for(TreeNode r : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        liste.add(node);
                    }
                }
            } //End of loop
            return liste;
        }

        //----------------------------------------------------------------------
        public LinkedList<TreeNode> generate_trees(int start, int end) {
            LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
            if (start > end) {
                all_trees.add(null);
                return all_trees;
            }
            // pick up a root
            for (int i = start; i <= end; i++) {
                // all possible left subtrees if i is choosen to be a root
                LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
                // all possible right subtrees if i is choosen to be a root
                LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
                // connect left and right trees to the root i
                for (TreeNode l : left_trees) {
                    for (TreeNode r : right_trees) {
                        TreeNode current_tree = new TreeNode(i);
                        current_tree.left = l;
                        current_tree.right = r;
                        all_trees.add(current_tree);
                    }
                }
            }
            return all_trees;
        }
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generate_trees(1, n);
        }
        //----------------------------------------------------------------

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
