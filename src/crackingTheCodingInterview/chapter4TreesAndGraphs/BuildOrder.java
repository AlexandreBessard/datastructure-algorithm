package crackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.*;

/*
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
projects, where the second project is dependent on the first project). All of a project's dependencies
must be built before the project is. Find a build order that will allow the projects to be built. If there
is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c
 */
public class BuildOrder {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };
        var obj = new BuildOrder();
        var result = obj.findBuildOrder(projects, dependencies);
        for(Project p : result) {
            //Output: f, e, a, b, d, c
            System.out.print(p.name + ", ");
        }
    }

    //Approach using DFS
    public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies)  {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Stack<Project> orderProjects(List<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for(Project project : projects) {
            if(project.getState() == Project.State.BLANK) {
                if(!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> stack) {
        if(project.getState() == Project.State.PARTIAL) {
            return false; // Cycle
        }
        if(project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            List<Project> children = project.getChildren();
            for(Project child : children) {
                if(!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    //Build graph, adding the edge (a, b) if b is dependent on 'a'
    //indicates that b depends on 'a' and  must be built before 'b'
    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for(String project : projects) {
            graph.getOrCreateNode(project);
        }
        for(String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    static class Graph {
        private List<Project> nodes = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();
        public Project getOrCreateNode(String name) {
            if(!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }
        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }
        public List<Project> getNodes() {
            return nodes;
        }
    }

    static class Project {
        enum State {COMPLETE, PARTIAL, BLANK};
        private List<Project> children = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();
        int dependencies;
        State state = State.BLANK;
        String name;
        public Project(String name) {
            this.name = name;
            dependencies = 0;
        }
        public void addNeighbor(Project node) {
            if(!map.containsKey(node.name)) {
                children.add(node);
                map.put(node.name, node);
                node.incrementDependencies();
            }
        }
        public List<Project> getChildren(){
            return this.children;
        }
        public void incrementDependencies() {
            this.dependencies++;
        }
        public State getState(){
            return this.state;
        }
        public void setState(State state) {
            this.state = state;
        }
    }

}
