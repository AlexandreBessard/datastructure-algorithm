package leetcode.datastructure.graph.topologicalSorting.Kahn.excercices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3953/
public class MinimumHeightTree {
    /*
    Better explanation:
    https://www.geeksforgeeks.org/roots-tree-gives-minimum-height/
    */
    public static void main(String[] args) {
        int[][] edges =  { {3,0},{3,1},{3,2},{3,4},{5,4}};
        new MinimumHeightTree().findMinHeightTrees(6, edges).forEach(e ->
                System.out.println(e + " ")
        );
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2) {
            List<Integer> centroids = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                centroids.add(i);
            }
        }
        //Build graph
        List<Set<Integer>> neighbors = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }
        for(int[] edge: edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        //Initialize the first layers.
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        //Trim the leaves until reach centroids
        int remainingNode = n;
        //exit the loop when 2
        while(remainingNode > 2) {
            remainingNode -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            //remove current leaves along with edges
            for(Integer leave: leaves) {
                //Only neighbor left for leave node
                Integer neighbor = neighbors.get(leave).iterator().next();
                //remove the edge along with leaf node
                neighbors.get(neighbor).remove(leave);
                if(neighbors.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
