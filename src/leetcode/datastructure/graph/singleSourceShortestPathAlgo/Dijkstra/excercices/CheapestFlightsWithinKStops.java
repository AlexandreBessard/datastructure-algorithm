package leetcode.datastructure.graph.singleSourceShortestPathAlgo.Dijkstra.excercices;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int[][] flights =
                { {0,1,100},{1,2,100},{2,0,200},{1,3,600},{2,3,200} };
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 3;
        //Output 700
        System.out.println(new CheapestFlightsWithinKStops()
                .findCheapestPrice(n, flights, src, dst, k));
    }

    /*
    Dijkstra's Algorithm
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //Build the adjacency matrix
        int[][] adjMatrix = new int[n][n];
        for(int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        //Shortest distance array
        int[] distances = new int[n];
        //Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;
        //Q would contain (node, cost, stops)
        //Based on cost (cheaper one)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});
        while(!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];
            //If destination if reached return the cost to get there
            if(node == dst) return cost;
            //If no more steps left, continue
            if(stops == K + 1) continue;
            //Examine and relax al neighboring edges if possible
            for(int nei = 0; nei < n; nei++) {
                if(adjMatrix[node][nei] > 0) {
                    int dU = cost;
                    int dV = distances[nei];
                    int wUV = adjMatrix[node][nei];
                    //Better cost?
                    if(dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    } else if (stops < currentStops[nei]) {
                        //Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                    }
                    currentStops[nei] = stops;
                }
            }
        }
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
