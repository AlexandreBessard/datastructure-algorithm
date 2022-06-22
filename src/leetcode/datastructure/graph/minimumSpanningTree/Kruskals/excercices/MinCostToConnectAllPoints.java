package leetcode.datastructure.graph.minimumSpanningTree.Kruskals.excercices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = { {0,0},{2,2},{3,10},{5,2},{7,0} };
        //Output: 20
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> allEdges = new ArrayList<>();
        //Sorting all edges of our complete graph
        for(int currNext = 0; currNext < n; currNext++) {
            for(int nextNext = currNext + 1; nextNext < n; ++nextNext) {
                int weight = Math.abs(points[currNext][0] - points[nextNext][0]) +
                        Math.abs(points[currNext][1] - points[nextNext][1]);

                int[] currEdge = {weight, currNext, nextNext};
                allEdges.add(currEdge);
            }
        }
        //Sort all edges in increasing order
        allEdges.sort(Comparator.comparingInt(a -> a[0]));
        //Connect two nodes between them
        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;
        for(int i = 0; i < allEdges.size() && edgesUsed < n - 1; i++) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];
            if(uf.union(node1, node2)) {
                mstCost += weight;
                edgesUsed++;
            }
        }
        return mstCost;
    }

    static class UnionFind {
        public int[] group;
        public int[] rank;

        public UnionFind(int size) {
            group = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++) {
                group[i] = i;
            }
        }

        private int find(int node) {
            if(group[node] != node) {
                group[node] = find(group[node]);
            }
            return group[node];
        }

        public boolean union(int node1, int node2) {
            int group1 = find(node1);
            int group2 = find(node2);
            //Node1 and Node2 belong to the same group
            if(group1 == group2) return false;

            if(rank[group1] > rank[group2]) {
                group[group2] = group[group1];
            } else if(rank[group1] < rank[group2]) {
                group[group1] = group[group2];
            } else {
                group[group1] = group[group2];
                rank[group2] += 1;
            }
            return true;
        }

    }
}
