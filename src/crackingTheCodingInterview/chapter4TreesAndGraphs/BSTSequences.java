package crackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
BST Sequences: A binary search tree was created by traversing through an array from left to right
and inserting each element. Given a binary search tree with distinct elements, print all possible
arrays that could have led to this tree.
 */
public class BSTSequences {

    public static void main(String[] args) {

    }

    public List<LinkedList<Integer>> allSequences(TreeNode node) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if(node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);
        //Recurse on left and right subtree
        List<LinkedList<Integer>> leftSeq = allSequences(node.left);
        List<LinkedList<Integer>> rightSeq = allSequences(node.right);
        //Weave together each list from the left and right sides
        for(LinkedList<Integer> left : leftSeq) {
            for(LinkedList<Integer> right : rightSeq) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }
    /*
    Weave list together an all possible ways.
    algo works by removing the head from one list, recursing and then doing the same thing
    with the other list.
     */
    private void weaveLists(LinkedList<Integer> first,
                            LinkedList<Integer> second,
                            List<LinkedList<Integer>> results,
                            LinkedList<Integer> prefix)
    {
        //One list is empty, Add remainder to [a cloned] prefix and store result
        if(first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        /*
        Recurse with head of first added to the prefix. Removing the head will
        damage first, so we'll need to put it back where we found it afterwards.
         */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        //Do the same thing with the second, damaging and then restoring the list
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
