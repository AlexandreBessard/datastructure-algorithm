package crackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;

/*
Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).
 */
public class PathsWithSum {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.left.left = new TreeNode(2);
        one.left.right = new TreeNode(1);
        one.left.right.left = new TreeNode(1);
        one.right = new TreeNode(3);
        one.right.left = new TreeNode(1);

        var obj = new PathsWithSum();
        System.out.println(obj.countPathWithSumOptimized(one, 3));
    }


    /*
    Solution 2: Optimized.
    Time complexity: O(N), where N is the number of nodes in the tree.
    O(N) because we travel to each node just once doing O(1) work each time.
    In balanced tree, the space complexity is O(log N) due to hash table.
    Can grow to O(n) in an unbalanced tree.
     */
    public int countPathWithSumOptimized(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }
    //In the Map, the value correspond to the number of path found from another branch left or right
    //It is like memoized to know how many path found at that current node.
    private int countPathsWithSum(TreeNode node,
                                  int targetSum,
                                  int runningSum,
                                  Map<Integer, Integer> pathCount)
    {
        if(node == null)  //Base case
            return 0;
        //Count paths with the sum ending at the current node
        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        //If runningSum equals targetSum, then one additional path starts at root.
        //Add this path
        if(runningSum == targetSum) {
            totalPaths++;
        }
        //Increment pathCount, recurse, then decrement pathCount
        incrementHashTable(pathCount, runningSum, 1); //Increment pathCount
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount
        return totalPaths;
    }
    private void incrementHashTable(Map<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if(newCount == 0) { //Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }


    //Brute force approach
    /*
    Time complexity:
    countPathsWithSumFromNode() will be called O(N log N) times.
     */
    public int countPathsWithSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        //Count paths with sum starting from the root
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        //Try the nodes on the left and right
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);
        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }
    private int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if(node == null)
            return 0;
        currentSum += node.value;
        int totalPaths = 0;
        if(currentSum == targetSum) { //Find a path from the root
            totalPaths++;
        }
        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;

    }


}
