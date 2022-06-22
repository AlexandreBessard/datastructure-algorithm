package leetcode.datastructure.graph.disjointSet.excercices;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3913/
public class SmallestStringWithSwaps {

    /*
    lexicographically: dictionary order
    See from the website to understand time and space complexity
     */
    public static void main(String[] args) {

    }

    /*
    Approach 2: Disjoint Set Union (DSU)
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> edge: pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);
            //Perform the union of endpoints
            uf.union(source, destination);
        }
        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        //Group the vertices that are in the same component
        for(int vertex = 0; vertex < s.length(); vertex++) {
            int root = uf.find(vertex);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }
        //String to store the answer
        char[] smallestString = new char[s.length()];
        //Iterate over each component
        for(List<Integer> indices: rootToComponent.values()) {
            //Sort the characters in the group
            List<Character> characters = new ArrayList<>();
            for(int index: indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            //Store the sorted characters
            for(int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }
        }
        return new String(smallestString);
    }

    static class UnionFind {
        private int[] root;
        private int[] rank;

        UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            for(int i = 0; i < size; i++) {
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }

        //Get root of the vertex
        private int find(int x) {
            if(x == this.root[x]) {
                return x;
            }
            return this.root[x] = find(this.root[x]);
        }

        //Perform union of two components
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                if(this.rank[rootX] >= this.rank[rootY]) {
                    this.root[rootY] = rootX;
                    this.rank[rootX] += rank[rootY];
                } else {
                    this.root[rootX] = rootY;
                    this.root[rootY] += this.root[rootX];
                }
            }
        }
    }
}
