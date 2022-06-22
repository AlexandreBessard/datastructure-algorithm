package leetcode.datastructure.graph.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3854/
public class AllPathFromSourceToTarget {

    public static void main(String[] args) {
        int[][] edges = { {1,2}, {3}, {3}, {} };
        new AllPathFromSourceToTarget().allPathsSourceTarget(edges)
                .forEach(System.out::println);
    }

    /*
    Time complexity: 0(2v . V) Here V represents the number of vertices
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();
        if(graph == null || graph.length == 0) {
            return results;
        }
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        q.add(path);
        while(!q.isEmpty()) {
            List<Integer> curr = q.poll();
            int node = curr.get(curr.size() - 1);
            for(int el: graph[node]) {
                List<Integer> tmp = new ArrayList<>(curr);
                tmp.add(el);
                if(el == graph.length - 1) {
                    results.add(new ArrayList<>(tmp));
                } else {
                    q.add(tmp);
                }
            }
        }
        return results;
    }
}
