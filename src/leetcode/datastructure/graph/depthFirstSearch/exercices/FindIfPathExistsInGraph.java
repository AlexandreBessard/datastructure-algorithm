package leetcode.datastructure.graph.depthFirstSearch.exercices;

import java.util.*;

public class FindIfPathExistsInGraph {

    public static void main(String[] args) {
        int num = 3;
        //Path 0 -> 1 -> 2
        //Path 0 -> 2
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        int source = 0;
        int destination = 2;
        //OTHER CASE
        int num2 = 6;
        int[][] edges2 = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        int source2 = 0;
        int destination2 = 5;
        //Output true or false
        System.out.println(new FindIfPathExistsInGraph().validPath(num2, edges2, source2, destination2));
    }


    public boolean validPath(int n, int[][] edges, int start, int end) {
        HashSet<Integer>[] set = new HashSet[n];
        for(int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
        }
        for(int[] edge: edges) {
            set[edge[0]].add(edge[1]);
            set[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if(current == end) return true;
            for(int edge: edges[current]) {
                if(!visited[current]) {
                    visited[edge] = true;
                    stack.push(edge);
                }
            }
        }
        return false;
    }
}
