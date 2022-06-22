package leetcode.datastructure.graph.topologicalSorting.Kahn.excercices;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3954/
public class ParallelCourses {

    /*
    Breadth-First Search (Kahn's Algorithm)
     */
    public static void main(String[] args) {
        //int[][] relations = { {1,3},{2,3} };
        int[][] relations = { {2,4}, {1,3}, {3,4}, {3,5}, {4,5}, {4,6}, {5, 6} };
        //Output: 6
        System.out.println(new ParallelCourses().test(6, relations));
    }

    /*
    TEST
     */
    public int test(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inCount = new int[N + 1];
        for(int[] edge: relations) {
            graph.get(edge[0]).add(edge[1]);
            inCount[edge[1]]++;
        }
        int steps = 0;
        int numNode = 0;
        List<Integer> q = new ArrayList<>();
        List<Integer> newQ;
        for(int node = 1; node < N + 1; node++) {
            if(inCount[node] == 0) q.add(node);
        }
        while(!q.isEmpty()) {
            steps++;
            newQ = new ArrayList<>();
            for(int node: q) {
                numNode++;
                for(int n: graph.get(node)) {
                    inCount[n]--;
                    if(inCount[n] == 0) {
                        newQ.add(n);
                    }
                }
            }
            q = newQ;
        }
        return numNode == N ? steps : -1;
    }

    public int minimumSemesters(int N, int[][] relations) {
        int[] inCount = new int[N + 1]; // or indegree
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            inCount[relation[1]]++;
        }
        int step = 0;
        int studiedCount = 0;
        List<Integer> bfsQueue = new ArrayList<>();
        for (int node = 1; node < N + 1; node++) {
            if (inCount[node] == 0) {
                bfsQueue.add(node);
            }
        }
        // start learning with BFS
        while (!bfsQueue.isEmpty()) {
            // start new semester
            step++;
            List<Integer> nextQueue = new ArrayList<>();
            for (int node : bfsQueue) {
                studiedCount++;
                for (int endNode : graph.get(node)) {
                    inCount[endNode]--;
                    // if all prerequisite courses learned
                    if (inCount[endNode] == 0) {
                        nextQueue.add(endNode);
                    }
                }
            }
            bfsQueue = nextQueue;
        }
        // check if learn all courses
        return studiedCount == N ? step : -1;
    }
}
