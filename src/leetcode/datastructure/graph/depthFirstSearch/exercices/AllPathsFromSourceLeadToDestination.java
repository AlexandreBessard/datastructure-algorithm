package leetcode.datastructure.graph.depthFirstSearch.exercices;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {

    /*
    does every path linearly connect to destination and destination doesn't have any outgoing paths.
     */
    public static void main(String[] args) {
        //true
        int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
        //False
        int[][] edges1 = {{0,1},{0,2}};
        System.out.println(new AllPathsFromSourceLeadToDestination()
                .leadsToDestination(4, edges, 0, 3));
    }


    /*
    WHITE: vertex is not processed yet.
    GRAY: Vertex is being processed DFS for this vertex has started, but not finished which means that
    all descendants (in DFS tree) of this vertex are not processed yet
    (or this vertex is in the function call stack).
    BLACK: Vertex and all its descendants are processed.
     */
    //Not white (equivalent of null values in the array
    enum Color { GRAY, BLACK};

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }

    private boolean leadsToDest(List<Integer>[] graph, int node, int dest, Color[] states) {
        //If GRAY: backward edge, create a loop
        if(states[node] != null) {
            return states[node] == Color.BLACK;
        }
        //It this is a leaf node, should be equal to destination
        if(graph[node].isEmpty()) {
            return node == dest;
        }
        //Processing this node
        states[node] = Color.GRAY;
        for(int next: graph[node]) {
            //If we get false, we short circuit and return from there.
            if(!leadsToDest(graph,next, dest, states)){
                return false;
            }
        }
        //Recursive processing done.
        states[node] = Color.BLACK;
        return true;
    }

    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }
}
