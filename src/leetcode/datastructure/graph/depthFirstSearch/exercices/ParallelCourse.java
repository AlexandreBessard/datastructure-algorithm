package leetcode.datastructure.graph.depthFirstSearch.exercices;

import leetcode.datastructure.graph.topologicalSorting.Kahn.excercices.ParallelCourses;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3954/
class ParallelCourse {

        public static void main(String[] args) {
            int[][] relations = { {2,4}, {1,3}, {3,4}, {3,5}, {4,5}, {4,6}, {5, 6} };
            System.out.println(new
                    ParallelCourse().minimumSemesters(6, relations));
        }

        /*
        DFS approach
         */
        public int minimumSemesters(int N, int[][] relations) {
            List<List<Integer>> graph = new ArrayList<>(N + 1);
            for(int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for(int[] relation: relations) {
                graph.get(relation[0]).add(relation[1]);
            }
            //Check if graph contains a cycle
            int[] visited = new int[N + 1];
            for(int node = 1; node < N + 1; node++) {
                //If have cycle return -1, else 6
                if(dfsCheckCycle(node, graph, visited) == -1) return -1;
            }
            //If no cycle, return the longest path
            int[] visitedLength = new int[N + 1];
            int maxLength = 1;
            for(int node = 1; node < N + 1; node++) {
                int length = dfsMaxPath(node, graph, visitedLength);
                maxLength = Math.max(length, maxLength);
            }
            return maxLength;
        }

        private int dfsMaxPath(int node, List<List<Integer>> graph, int[] visitedLength) {
            //Return the longest path (inclusive)
            if(visitedLength[node] != 0) {
                return visitedLength[node];
            }
            int maxLength = 1;
            for(int endNode: graph.get(node)) {
                int lenfth = dfsMaxPath(endNode, graph, visitedLength);
                maxLength = Math.max(lenfth + 1, maxLength);
            }
            //Store it
            visitedLength[node] = maxLength;
            return maxLength;
        }


        //If -1 -> we have a cycle
        private int dfsCheckCycle(int node, List<List<Integer>> grap, int[] visited) {
            //return the longest path (inclusive)
            if(visited[node] != 0) {
                return visited[node];
            }
            int maxLength = 1;
            for(int endNode: grap.get(node)) {
                int length = dfsCheckCycle(endNode, grap, visited);
                maxLength = Math.max(length + 1, maxLength);
            }
            //store it
            visited[node] = maxLength;
            return maxLength;
        }
}
