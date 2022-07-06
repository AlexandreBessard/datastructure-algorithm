package crackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths {
    public static void main(String[] args) {
        var obj = new ListOfDepths();
        obj.createLevelLinkedList(new TreeNode(1));
    }


    public List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    /*
    Time complexity: O(N)
    Space complexity:
     */
    //Optimized (without recursion)
    private List<LinkedList<TreeNode>> createLevelLinkedListOptimized(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        //Visit the root
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null) {
            current.add(root);
        }
        while(current.size() > 0) {
            result.add(current);  //Add previous level
            LinkedList<TreeNode> parents = current; //Go to the next level
            current = new LinkedList<>();
            for(TreeNode parent : parents) {
                //Visit the children
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    /*
    Time complexity: O(N)
    Space complexity: O(log N) for recursive calls in a balanced tree
     */
    //Non-optimized (recursion)
    private void createLevelLinkedList(TreeNode root,
                                      List<LinkedList<TreeNode>> lists,
                                      int level)
    {
        if(root == null)
            return; //base case
        LinkedList<TreeNode> list = null;
        if(lists.size() == level) { //Level not contained in list
            list = new LinkedList<>();
            //Levels are always traversed in order
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }
}
