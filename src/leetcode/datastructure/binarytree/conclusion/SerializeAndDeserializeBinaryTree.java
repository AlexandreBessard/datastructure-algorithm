package leetcode.datastructure.binarytree.conclusion;

import amazon.treesandgraphs.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
public class SerializeAndDeserializeBinaryTree {

    /*
    Time complexity: O(N), we visit each node exactly once for serialization and deserialization.
    Space complexity: O(N), Keep the entire tree at the beginning or at the end. therefore
    the space complexity is O(N)
     */


    public static void main(String[] args) {

    }

    //Deserialize
    public TreeNode deserialize(String s) {
        String[] array = s.split(",");
        List<String> l = new LinkedList<>(Arrays.asList(array));
        return rdeserialize(l);
    }

    private TreeNode rdeserialize(List<String> l) {
        if(l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode curr = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        curr.left = rdeserialize(l);
        curr.right = rdeserialize(l);
        return curr;
    }

    /*
    -----------------------------------------------------
     */

    //Serialize DSF: preorder: node -> left -> right
    public String serialize(TreeNode n) {
        return rserialize(n, "");
    }

    private String rserialize(TreeNode n, String s) {
        if(n == null) {
            return s += "null,";
        }
        s += n.value + ",";
        s = rserialize(n.left, s);
        s = rserialize(n.right, s);
        return s;
    }

}
