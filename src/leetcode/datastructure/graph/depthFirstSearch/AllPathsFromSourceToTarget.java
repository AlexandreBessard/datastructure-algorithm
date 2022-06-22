package leetcode.datastructure.graph.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3850/
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        var obj = new AllPathsFromSourceToTarget();
        int[][] graph = {{1,2},{3},{3},{}};
        obj.allPathsSourceTarget(graph).forEach(System.out::print);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph == null || graph.length == 0) return paths;
        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if(node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for(int nextNode: nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
