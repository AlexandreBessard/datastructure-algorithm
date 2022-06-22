package leetcode.datastructure.binarytree.solveproblemrecursively;

import amazon.treesandgraphs.utils.TreeNode;

//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/538/
public class CountUnivalueSubtrees {

    /*
    Time complexity: O(N), when given the 'is_uni' status of its children, computing the 'is_uni'
    status of the node occurs O(1)
    This given O(1) time for each node in the tree with O(N) total nodes for a time complexity
    of O(N)

    Space complexity: O(H) with h being the height of the tree. Each recursive call 'is_uni' required
    stack space. We fully process 'is_uni(node.left)' before calling 'is_uni(node.right)'.
     */
    public static void main(String[] args) {

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        five.left = one;
        TreeNode five1 = new TreeNode(5);
        five.left.left = five1;
        TreeNode five2 = new TreeNode(5);
        five.left.right = five2;

        TreeNode five3 = new TreeNode(5);
        five.right = five3;
        TreeNode five4 = new TreeNode(5);
        five.right.right = five4;

        //Ouput 4
        System.out.println(new CountUnivalueSubtrees().countUnivalSubtrees(five));
    }

    int count = 0;

    public boolean is_uni(TreeNode node) {
        if(node.left == null && node.right == null){
            count++;
            return true;
        }
        boolean is_uni = true;
        if(node.left != null) {
            is_uni = is_uni(node.left) && is_uni && node.value == node.left.value;
        }
        if(node.right != null) {
            is_uni = is_uni(node.right) && is_uni && node.value == node.right.value;
        }
        if(!is_uni) return false;
        count++;
        return true;
    }

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return count;
        is_uni(root);
        return count;
    }

}
