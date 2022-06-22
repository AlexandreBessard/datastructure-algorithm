package leetcode.datastructure.graph.minimumSpanningTree.Prims.exercices;

import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[][] points = { {0,0},{2,2},{3,10},{5,2},{7,0} };
        //Output 20.
        System.out.println(new Test().minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int size = points.length;
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
                (x, y) -> x.getKey() - y.getKey());
        boolean[] isMst = new boolean[size];
        heap.add(new Pair<>(0, 0));
        int edges = 0;
        int result = 0;
        while(edges < size) {
            var pair = heap.poll();
            int currNode = pair.getValue();
            if(isMst[currNode]) continue;
            result += pair.getKey();
            for(int nextNode = 0; nextNode < size; nextNode++) {
                int weight = Math.abs(points[currNode][0] - points[nextNode][0])
                        + Math.abs(points[currNode][1] - points[nextNode][1]);
                heap.add(new Pair<>(weight, nextNode));
            }
            isMst[currNode] = true;
            edges++;
        }
        return result;
    }

    static class Pair<K, V> {

        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        @Override
        public int hashCode(){
            return 31 * key.hashCode() + value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Pair<K, V> pair = (Pair<K, V>) o;
            if(!this.key.equals(pair.key)) return false;
            return this.value.equals(pair.value);
        }

        @Override
        public String toString() {
            return "Key : " + key + " Value : " + value;
        }
    }
}
