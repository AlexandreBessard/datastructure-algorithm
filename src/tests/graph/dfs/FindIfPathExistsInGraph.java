package tests.graph.dfs;

import leetcode.datastructure.graph.depthFirstSearch.FindIfPathExistsInGraphDFS;

import java.util.*;

public class FindIfPathExistsInGraph {

    public static void main(String[] args) {
        var obj = new FindIfPathExistsInGraph();
        //n represents n vertices
        int  n = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {0, 3}
        };
        System.out.println("DFS => " + obj.hasExistingPath(4, edges, 0, 2));
        System.out.println("BFS => " + obj.hasExistingPathBFS(4, edges, 0, 2));

    }

    /*
    BFS
    Use a Queue.
    FIFO
    Create adjacencyList to have the neighbors.
     */
    public boolean hasExistingPathBFS(int n,
                                      int[][] edges, int start, int end) {
        List<List<Integer>> adjacentList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacentList.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[n];
        q.add(start);
        seen[start] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            if(node == end) return true;
            for(int el : adjacentList.get(node)) {
                if(!seen[el]) {
                    seen[el] = true;
                    q.add(el);
                }
            }
        }
        return false;
    }


    public boolean hasExistingPath(int numOfEdges, int[][] graph, int start, int end) {
        //Create adjacentList
        List<List<Integer>> adjList = new ArrayList<>(numOfEdges);
        for(int i = 0; i < numOfEdges; i++) {
            adjList.add(new ArrayList<>());
        }
        //Loop through each graph to construct our adjacentList
        for(int[] g: graph) {
            adjList.get(g[0]).add(g[1]);
            adjList.get(g[1]).add(g[0]);
        }
        //Create a stack
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[numOfEdges];
        //Arrays.fill(visited, false);
        s.push(start);
        while(!s.isEmpty()) {
            int edge = s.pop();
            if(edge == end) return true;
            if(visited[edge]) continue;
            visited[edge] = true;
            for(int el : adjList.get(edge)) {
                s.push(el);
            }
        }
        return false;
    }


}
