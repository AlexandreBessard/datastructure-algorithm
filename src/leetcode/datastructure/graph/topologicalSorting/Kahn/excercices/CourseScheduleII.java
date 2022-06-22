package leetcode.datastructure.graph.topologicalSorting.Kahn.excercices;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3868/
public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] prerequisites = { {1,0},{2,0},{3,1},{3,2} };
        System.out.println(Arrays.toString(
                Arrays.stream(
                new CourseScheduleII().findOrder(4, prerequisites)).toArray()
        ));
    }

    /*
    Khan's algorithm
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        //Create the adjacency list representation of the graph
        for(int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            //key, default value.
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
            //Record in-degree for each vertex
            indegree[dest] += 1;
        }
        //Add all vertices with 0 in-degree to the Queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int i = 0;
        //Process Q until queue becomes empty
        while(!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;
            //Reduce in-degree for each neighbor by 1
            if(adjList.containsKey(node)) {
                for(Integer neighbor: adjList.get(node)) {
                    indegree[neighbor]--;
                    //If in-degree of neighbor becomes 0, add it to the Q
                    if(indegree[neighbor] == 0) q.add(neighbor);
                }
            }
        }
        //Check if topological sort is possible or not
        if(i == numCourses) return topologicalOrder;
        return new int[0];
    }
}
