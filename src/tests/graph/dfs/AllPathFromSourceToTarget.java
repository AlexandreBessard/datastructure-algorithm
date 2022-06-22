package tests.graph.dfs;

import leetcode.datastructure.graph.depthFirstSearch.AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathFromSourceToTarget {

    public static void main(String[] args) {
        var obj = new AllPathFromSourceToTarget();
        int[][] graph = {{1,2},{3},{3},{}};
        obj.allPathsSourceTarget(graph).forEach(System.out::print);
        System.out.println();
        obj.allPathsFromSourceToTargetBFS(graph).forEach(System.out::print);

    }

    /*
    BFS
    Time complexity:
    Complexity Analysis:
    https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3854/
     */
    public List<List<Integer>> allPathsFromSourceToTargetBFS(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if(graph == null || graph.length == 0) return result;
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        q.add(path);
        while(!q.isEmpty()) {
            List<Integer> currentPath = q.poll();
            int node = currentPath.get(currentPath.size() - 1);
            for(int el : graph[node]) {
                List<Integer> tmpList = new ArrayList<>(currentPath);
                tmpList.add(el);
                if(tmpList.size() == graph.length - 1){
                    result.add(tmpList);
                } else {
                    q.add(tmpList);
                }
            }
        }
        return result;
    }


    /*
    DFS
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        dsf(0,new ArrayList<>(), graph, result);
        return result;
    }

    private void dsf(int node,
                     List<Integer> path,
                     int[][] graph,
                     List<List<Integer>> result)
    {
        path.add(node);
        if(node == graph.length - 1){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int el : graph[node]) {
            dsf(el, path, graph, result);
            path.remove(path.size() - 1);
        }

    }

}
