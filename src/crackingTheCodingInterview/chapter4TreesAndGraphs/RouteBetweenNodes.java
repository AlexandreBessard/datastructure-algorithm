package crackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
 */
public class RouteBetweenNodes {

    public static void main(String[] args) {

    }

    public boolean search(Graph g, Node start, Node end) {
        if(start == end)
            return true;
        LinkedList<Node> q = new LinkedList<>();
        for(Node u : g.getNode()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.removeFirst(); // dequeue
            if(u != null) {
                for(Node v : u.getAdjacent()) {
                    if(v.state == State.Unvisited) {
                        if(v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
            }
            u.state = State.Visited;
        }
        return false;
    }

    static class Graph {
        public List<Node> getNode(){
            return new ArrayList<>(Arrays.asList(new Node()));
        }
    }
    static class Node {
        State state;
        private List<Node> adjacent;
        public List<Node> getAdjacent() {
            return adjacent;
        }
    }
    enum State {
        Unvisited,
        Visited,
        Visiting
    }

}
