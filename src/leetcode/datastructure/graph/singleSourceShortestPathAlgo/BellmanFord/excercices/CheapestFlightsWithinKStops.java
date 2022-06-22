package leetcode.datastructure.graph.singleSourceShortestPathAlgo.BellmanFord.excercices;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3866/
public class CheapestFlightsWithinKStops {
    /*
    &1
    Value : 0, => 0
    Value : 1, => 1
    Value : 2, => 0
    Value : 3, => 1
     */
    public static void main(String[] args) {
        int[][] flights =
                { {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200} };
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;
        //Output 700
        System.out.println(new CheapestFlightsWithinKStops()
                .findCheapestPrice(n, flights, src, dst, k));
    }

    /*
    Bellman-Ford's Algorithm
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        long[][] distances = new long[2][n];
        Arrays.fill(distances[0], Integer.MAX_VALUE);
        Arrays.fill(distances[1], Integer.MAX_VALUE);
        distances[0][src] = 0;
        distances[1][src] = 0;
        for(int iterations = 0; iterations < K + 1; iterations++) {
            //Iterate over all the edges
            for(int[] edge: flights) {
                int s = edge[0];
                int d = edge[1];
                int wUV= edge[2];
                //Current distance of node "s" from src
                //&1: 0 if even number or 1 if odd number
                long dU = distances[1 - iterations&1][s];
                //Current distance of node "d" from src
                //Note: will port existing values as well from the "previous" array
                //If they didn't already exist
                long dV = distances[iterations&1][d];
                //Relax the edge if possible
                //If you add 2 max values, it is inferior than 1 max value
                if(wUV + dU < dV) {
                    distances[iterations&1][d] = dU + wUV;
                }
            }
        }
        return distances[K&1][dst] < Integer.MAX_VALUE ? (int)distances[K&1][dst] : -1;
    }
}
