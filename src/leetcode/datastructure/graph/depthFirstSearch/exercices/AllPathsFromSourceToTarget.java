package leetcode.datastructure.graph.depthFirstSearch.exercices;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3849/
//Solution link below:
//https://leetcode.com/problems/all-paths-from-source-to-target/discuss/412377/Java-Iterative-with-Stack-and-Queue-and-statistics-comparing-Iterative-vs-Recursive-speeds
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        new AllPathsFromSourceToTarget().allPathsSourceTarget(graph);
    }





    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        //Keep track of nodes to process
        Deque<Integer> stack = new ArrayDeque<>();
        //Path generated so far
        Deque<Integer> path = new ArrayDeque<>();
        stack.push(0);
        while(!stack.isEmpty()) {
            //need Integer object, not int because path.peekLast() will return null.
            //Can not compare null with an int but you can with an Integer
            Integer current = stack.peek();
            if(current == path.peekLast()) {
                //top of the stack match top of the queue, we have
                //processes all this node's connections
                //Remove one node to process
                stack.pop();
                //Go back one step in the path
                path.removeLast();
                continue;
            }
            //Equivalent of offerLast()
            path.offer(current);
            Integer end = graph.length - 1;
            if(current == end) {
                //Found a path
                result.add(new ArrayList<>(path));
            }
            //We have not seen this node before
            //add al of this node's neighbors to the stack of nodes to process.
            for(int neighbor: graph[current]) {
                //Equivalent to add first
                stack.push(neighbor);
            }
        }
        return result;
    }
}
