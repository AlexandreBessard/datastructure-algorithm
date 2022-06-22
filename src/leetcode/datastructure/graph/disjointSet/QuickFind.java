package leetcode.datastructure.graph.disjointSet;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3878/
public class QuickFind {

    class UnionFind {
        /*
        Space complexity: O(N) space to store the array of size N.
         */
        private int[] root;

        /*
        Time complexity: O(N): Union-find constructor
         */
        public UnionFind(int size) {
            root = new int[size];
            for(int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        /*
        O(1)
         */
        public int find(int x) {
            return this.root[x];
        }

        /*
        O(N)
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                for(int i = 0; i < this.root.length; i++) {
                    if(this.root[i] == rootY) {
                        this.root[i] = rootX;
                    }
                }
            }
        }

        public boolean connected(int x, int y) {
            return this.root[x] == this.root[y];
        }

    }


}
