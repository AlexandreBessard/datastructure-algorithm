package leetcode.datastructure.graph.singleSourceShortestPathAlgo.Dijkstra.excercices;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3863/
public class NetworkDelayTime {

    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    public static void main(String[] args) {
        /*
        0: source node
        1: target node
        2: time from source to target node
         */
        int[][] times = { {2,1,1},{2,3,1},{3,4,1} };
        //Output: 2
        System.out.println(new NetworkDelayTime()
                .networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //Build adjacency list
        for(int[] time: times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair<>(travelTime, dest));
        }
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        dijkstra(signalReceivedAt, k, n);
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }
        return answer;
    }

    private void dijkstra(int[] signalReceivedAt, int source, int n) {
        Queue<Pair<Integer, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.add(new Pair<>(0, source));
        //Time for starting node is 0
        signalReceivedAt[source] = 0;
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();
            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();
            if(currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }
            if(!adj.containsKey(currNode)) {
                continue;
            }
            //Broadcast signal to adjacent nodes
            for(Pair<Integer, Integer> edge: adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                //Fastest signal time for neighborNode
                //signalReceivedAt[currNodes] + time
                if(signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(new Pair<>(signalReceivedAt[neighborNode],neighborNode));
                }
            }
        }
    }

    static class Pair<K, V> {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public int hashCode(){
            return 31 * this.key.hashCode() + this.value.hashCode();
        }
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Pair<K, V> pair = (Pair<K, V>) o;
            if(!this.key.equals(pair.key)) return false;
            return this.value.equals(pair.value);
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}
