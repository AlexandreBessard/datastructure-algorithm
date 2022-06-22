package leetcode.datastructure.graph.disjointSet;

public class PathCompressionOptimization {

    static class UnionFind {
        int[] root;

        //Time complexity: O(N)
        public UnionFind(int size) {
            this.root = new int[size];
            for(int i = 0; i < root.length; i++) {
                this.root[i] = i;
            }
        }

        //O(log N)
        private int find(int x) {
            if(x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        //O(log N)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                root[rootY] = rootX;
            }
        }

        //O(log N)
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public static void main(String[] args) {
            UnionFind uf = new UnionFind(10);
            uf.union(1, 2);
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
        }

    }

}
