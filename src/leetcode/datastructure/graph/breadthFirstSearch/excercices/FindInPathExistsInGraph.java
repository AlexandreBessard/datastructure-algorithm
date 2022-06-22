package leetcode.datastructure.graph.breadthFirstSearch.excercices;

import java.util.*;

public class FindInPathExistsInGraph {

    public static void main(String[] args) {
        int[][] graph = {{0,1},{1,2},{2,0}};
        int[][] graph2 = {{0,1}, {0,2}, {0,3}, {1,4}, {2,4}};
        System.out.println(new FindInPathExistsInGraph()
                .validPath(5, graph2, 0, 4));
    }

    /*
    BFS
     */
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i;
        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        if(graph[start].contains(end)){  // direct connection exists
            return true;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int N, current;
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            N = queue.size();
            for(i = 0; i < N; i++){
                current = queue.poll();
                if(current == end){
                    return true;
                }
                for(Integer neighbor : graph[current]){
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return false;
    }
}

