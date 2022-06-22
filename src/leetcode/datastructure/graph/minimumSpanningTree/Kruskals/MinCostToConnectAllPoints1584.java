package leetcode.datastructure.graph.minimumSpanningTree.Kruskals;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3858/
public class MinCostToConnectAllPoints1584 {

    /*
    Time complexity: O(E log E). Here E represents the number of edges.
    For java, building a PriorityQueue takes O(E log E).
    Popping out all elements from the Queue takes O(E log E).
    Therefore: O(E log E) + O(E log E) = O(E log O)
    Space complexity: O(E). We need the space to store all edges in a priorityQueue
     */
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(new MinCostToConnectAllPoints1584()
                .minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int size = points.length;
        //Ascending order by cost
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        UnionFind uf = new UnionFind(size);
        for(int i = 0; i < size; i++) {
            int[] coordinate1 = points[i];
            for(int j = i + 1; j < size; j++) {
                int[] coordinate2 = points[j];
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
                Edge edge = new Edge(i, j, cost);
                pq.add(edge);
            }
        }
        int result = 0;
        int count = size - 1;
        while(! pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            if(!uf.connected(edge.point1, edge.point2)) {
                uf.union(edge.point1, edge.point2);
                count -= 1;
                result += edge.cost;
            }
        }
        return result;
    }

    static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            for(int i = 0; i < size; i++) {
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                if(this.rank[x] > this.rank[y]) {
                    this.root[y] = this.rank[x];
                } else if(this.rank[x] < this.rank[y]) {
                    this.root[x] = this.rank[y];
                } else {
                    this.root[y] = this.rank[x];
                    this.rank[x] += 1;
                }
            }
        }

        private int find(int x) {
            if(x == this.root[x]) {
                return x;
            }
            return this.root[x] = find(this.root[x]);
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    static class Edge {
        int point1, point2, cost;
        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

}
