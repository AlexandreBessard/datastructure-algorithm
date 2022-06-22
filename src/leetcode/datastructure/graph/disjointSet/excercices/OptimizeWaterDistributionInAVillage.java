package leetcode.datastructure.graph.disjointSet.excercices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3916/
public class OptimizeWaterDistributionInAVillage {

    public static void main(String[] args) {
        int num = 3;
        int[] wells = {1, 2, 2};
        int[][] pipes = {{1, 2, 1}, {2, 3, 1}};
        //Output 3
        System.out.println(new OptimizeWaterDistributionInAVillage()
                .minCostToSupplyWater(num, wells, pipes));
    }

    /*
    Approach 2: Kruskal's Algorithm with Union-FindIfPathExistsInGraphBFS
    Time complexity: N the number of houses and M the number of pipes from the input
    First we build a list of edges: O(N + M)
    Sort that list: O((N + M) . log(N + M)) time
    At the end, we iterate through the sorted edges. O((N+M)∗log∗(N))
    To sum up, the overall time complexity O((N + M) . log(N + M)) (dominated by sorting step)

    Space complexity: Union-FindIfPathExistsInGraphBFS: O(N)
    Space required by by the list of edges is O(n + M)
    Java: Collections.sort(): O(log N)
    To sum up: O(N + M) which is dominated by the list of edges.
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> orderedEdges = new ArrayList<>(n + 1 + pipes.length);
        for(int i = 0; i < wells.length; i++){
            orderedEdges.add(new int[]{0, i + 1, wells[i]});
        }
        //add existing edges
        for(int[] edge: pipes) {
            orderedEdges.add(edge);
        }
        Collections.sort(orderedEdges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        for(int[] edge: orderedEdges) {
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];
            System.out.println("[ " + house1 + ", " + house2 + ", " + cost + " ]");
            boolean result;
            if(result = (uf.union(house1, house2))) {
                System.out.print(result);
                totalCost += cost;
            }
        }
        return totalCost;
    }

    static class UnionFind {
        private int[] group;
        private int[] rank;

        UnionFind(int size) {
            this.group = new int[size + 1];
            this.rank = new int[size + 1];
            for(int i = 0; i < size + 1; i++) {
                this.group[i] = i;
                this.rank[i] = 1;
            }
        }

        private int find(int house) {
            while(house == this.group[house]){
                return house;
            }
            return this.group[house] = find(this.group[house]);
        }

        public boolean union(int house1, int house2) {
            int group1 = find(house1);
            int group2 = find(house2);
            if(group1 == group2) return false;
            if(this.rank[group1] > this.rank[group2]) {
                this.group[group2] = group1;
            } else if(this.rank[group1] < this.rank[group2]) {
                this.group[group1] = group2;
            } else {
                this.group[group1] = group2;
                this.rank[group2] += this.rank[group1];
            }
            return true;
        }

    }

}
