package leetcode.datastructure.graph.singleSourceShortestPathAlgo.BellmanFord;

//https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3867/
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int[][] flights = { {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200} };
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 2;
        //Output 700
        System.out.println(new CheapestFlightsWithinKStops()
                .findCheapestPrice(n, flights, src, dst, k));
    }

    //Bellman's Ford Algo
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;
        int[] previous = new int[n];
        int[] current = new int[n];
        for(int i = 0; i < n; i++) {
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        previous[src] = 0;
        //int[][] flights = { {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200} };
        for(int i = 1; i < k + 2; i++) {
            System.out.println("Value of i " + i);
            current[src] = 0;
            for(int[] flight: flights) {
                int previous_flight = flight[0];
                int current_flight = flight[1];
                int cost = flight[2];
                if(previous[previous_flight] < Integer.MAX_VALUE) {
                    current[current_flight] = Math.min(current[current_flight], previous[previous_flight] + cost);
                }
            }
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
    }
}
