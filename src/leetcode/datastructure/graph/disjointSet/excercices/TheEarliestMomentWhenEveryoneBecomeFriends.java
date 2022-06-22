package leetcode.datastructure.graph.disjointSet.excercices;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3912/
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        int[][] logs =
                {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};
        System.out.println(new TheEarliestMomentWhenEveryoneBecomeFriends().earliestAcq(logs, 4));
    }

    /*
    Time complexity: sort all the logs: (quick) sorting O(M log M)
    Create Union-FindIfPathExistsInGraphBFS O(N) to initialize array of group IDs
    Iterate through sorted logs (union) O(M & (N))
    sum up: O(N + M log M + M & (N))
    Space complexity:
    O(N + log M)
    Union-find datastructure: O(N) because we keep track of the group ID for each individual
    Arrays.sort() -> O(log M)
     */
    public int earliestAcq(int[][] logs, int n) {
        //Sort Chronological order
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer tsp1 = o1[0];
                Integer tsp2 = o2[1];
                return tsp1.compareTo(tsp2);
            }
        });
        int groupCount = n;
        UnionFind uf = new UnionFind(n);
        for(int[] log: logs) {
            int timestamp = log[0];
            int friendA = log[1];
            int friendB = log[2];
            //We merge the group along the way
            if(uf.union(friendA, friendB)) {
                groupCount -= 1;
            }
            //The moment when all individuals are connected each other
            if(groupCount == 1) {
                return timestamp;
            }
        }
        //There are still more than one group left:
        return -1;
    }

    static class UnionFind {

        private int[] group;
        private int[] rank;

        UnionFind(int size) {
            this.group = new int[size];
            this.rank = new int[size];
            for(int i = 0; i < size; i++) {
                this.group[i] = i;
                this.rank[i] = 1;
            }
        }

        private int find(int person) {
            if(person == this.group[person]) {
                return person;
            }
            return this.group[person] = find(this.group[person]);
        }

        //Return true if the group are merged
        public boolean union(int a, int b) {
            int groupA = this.find(a);
            int groupB = this.find(b);
            boolean isMerged = false;
            //Two people are in the same group
            if (groupA == groupB) return isMerged;
            //Otherwise, merge the 2 groups:
            isMerged = true;
            if(this.rank[groupA] > this.rank[groupB]) {
                this.group[groupB] = a;
            } else if(this.rank[groupA] < this.rank[groupB]) {
                this.group[groupA] = groupB;
            } else {
                this.group[groupA] = groupB;
                this.rank[groupA] += 1;
            }
            return isMerged;
        }

    }
}
