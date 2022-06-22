package leetcode.datastructure.graph.minimumSpanningTree.Prims.exercices;

import java.util.PriorityQueue;

//https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3860/
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = { {0,0},{2,2},{3,10},{5,2},{7,0} };
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(points));
    }

    /*
    Prim's algo
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Min-heap to store minimum weight edge at top.
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        // Track nodes which are included in MST.
        boolean[] inMST = new boolean[n];
        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        while (edgesUsed < n) {
            Pair<Integer, Integer> topElement = heap.poll();
            int weight = topElement.getKey();
            int currNode = topElement.getValue();
            // If node was already included in MST we will discard this edge.
            if (inMST[currNode]) {
                continue;
            }
            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                // If next node is not in MST, then edge from curr node
                // to next node can be pushed in the priority queue.
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1]);

                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        return mstCost;
    }

    static class Pair<K, V> {
        K key;
        V value;
        Pair(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()){
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            if(!key.equals(pair.key)) {
                return false;
            }
            return value.equals(pair.value);
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        @Override
        public int hashCode() {
            return 31 * key.hashCode() + value.hashCode();
        }

        @Override
        public String toString() {
            return "key: " + key + " value: " + value;
        }

        public static <K, V> Pair<K, V> of(K k, V v) {
            return new Pair<>(k, v);
        }
    }
}
