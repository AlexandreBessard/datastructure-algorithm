package leetcode.datastructure.graph.minimumSpanningTree.Prims;

import java.util.PriorityQueue;

//https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3861/
public class MinCostToConnectAllPoints1584 {

    /*
    Prim's algorithm
     */
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println("Minimum Cost to Connect Points = ");
        System.out.println(new MinCostToConnectAllPoints1584()
                .minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int size = points.length;
        boolean[] visited = new boolean[size];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((x, y) -> x.cost - y.cost);
        visited[0] = true;
        int[] coordinate1 = points[0];
        for(int j = 1; j < size; j++) {
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0])
                    + Math.abs(coordinate1[1] - coordinate2[1]);
            pq.add(new Edge(0, j, cost));
        }
        int result = 0;
        int count = size - 1;
        while(!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;
            if(!visited[point2]) {
                visited[point2] = true;
                result += cost;
                for(int j = 0; j < size; j++) {
                    if(!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0])
                                + Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, distance));
                    }
                }
                count--;
            }
        }
        return result;
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

