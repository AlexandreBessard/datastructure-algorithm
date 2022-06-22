package leetcode.datastructure.graph.depthFirstSearch.exercices;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        //int[][] graph = { {4,2},{1,3},{2,4},{1,3} };
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var neighbor1 = new ArrayList<>(Arrays.asList(node4, node2));
        var neighbor2 = new ArrayList<>(Arrays.asList(node1, node3));
        var neighbor3 = new ArrayList<>(Arrays.asList(node2, node4));
        var neighbor4 = new ArrayList<>(Arrays.asList(node1, node3));
        node1.neighbors = neighbor1;
        node2.neighbors = neighbor2;
        node3.neighbors = neighbor3;
        node4.neighbors = neighbor4;
        new CloneGraph().cloneGraph(node1);
    }

    Map<Node, Node> visited = new HashMap<>();

    /*
    Approach 1: Depth First Search
    Time complexity: O(N + M) when N number of node (vertices) and M number of edges.
    Space complexity: O(N) space occupied by the visited hashmap.
    Recursion stack: O(H) where H is the height of the graph.
     */
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        //Already visited? return cloned from the visited dictionary.
        if(visited.containsKey(node))
            return visited.get(node);
        //Create clone for the given node
        //We do not have to clone neighbors
        Node cloneNode = new Node(node.val, new ArrayList<>());
        //Key is the original node, value being clone node
        visited.put(node, cloneNode);
        //Iterate through the neighbors to generate their clones
        for(Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    static class Node {
        int val;
        List<Node> neighbors;
        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
        Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
