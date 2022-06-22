package leetcode.datastructure.graph.breadthFirstSearch.excercices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3853/
public class AllPathsFromSourceToTarget {

    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    public static void main(String[] args) {
        int[][] edges = {{1,2},{3},{3},{}};
        new AllPathsFromSourceToTarget().allPathsSourceTarget(edges)
                .forEach(e -> System.out.println(e));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtracking(0, path);
        return this.results;
    }

    private void backtracking(int currNode, LinkedList<Integer> path) {
        if(currNode == this.target) {
            results.add(new ArrayList<>(path));
            return;
        }
        for(int val: this.graph[currNode]) {
            path.addLast(val);
            backtracking(val, path);
            path.removeLast();
        }
    }
}
