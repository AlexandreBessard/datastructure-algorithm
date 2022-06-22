package leetcode.datastructure.graph.breadthFirstSearch;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/4152/
public class FindIfPathExistsInGraphBFS {

    public static void main(String[] args) {
        int[][] edges = {{0,2}, {0,1},{2,1},{1,3},{1,4}};
        System.out.println(new FindIfPathExistsInGraphBFS()
                .validPath(5, edges, 2, 3));
    }

    /*
    Time complexity: O(V + E). Here V represents the number of vertices and E represents
    the number of edges.
    Space complexity: O(V + E).
    adjacency list will contain O(V + E).
    queue will contain O(V) elements.
    seen: O(V) space to store visited nodes.
     */
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjency_list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adjency_list.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adjency_list.get(edge[0]).add(edge[1]);
            adjency_list.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //Example: q.add(1); q.add(2) --> [1, 2]
        queue.add(start);
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        seen[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == end) return true;
            //Add all neighbors to the stack
            for(int neighbor: adjency_list.get(start)) {
                if(!seen[neighbor]) {
                    seen[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
