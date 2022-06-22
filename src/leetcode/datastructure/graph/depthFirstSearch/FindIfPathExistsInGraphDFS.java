package leetcode.datastructure.graph.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/4151/
public class FindIfPathExistsInGraphDFS {

    public static void main(String[] args) {
        var obj = new FindIfPathExistsInGraphDFS();
        //n represents n vertices
        int  n = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {0, 3}
        };
        System.out.println(obj.validPath(4, edges, 0, 2));
    }


    /*
    Time complexity: O(V + E) where V represents the number of vertices and E represents the number of edges.
    To create adjency list we must iterate over the edges E.
    Space complexity: O(V + E)
    The adjacency list will contain O(V + E) elements.
    Stack contains O(E) but reduced to O(V) by checking if neighbor node has been seen before.
    seen set will use O(V) space to store the visited nodes.
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
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(node == end) return true;
            if(seen[node]) continue;
            seen[node] = true;
            for(int neighbor: adjency_list.get(node)) {
                stack.push(neighbor);
            }
        }
        return false;
    }

}
