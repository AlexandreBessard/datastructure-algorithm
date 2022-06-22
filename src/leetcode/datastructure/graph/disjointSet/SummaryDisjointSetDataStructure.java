package leetcode.datastructure.graph.disjointSet;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3844/
public class SummaryDisjointSetDataStructure {
    /*
    0  1  2  3  4  :: index (vertex)
    0  1  2  3  4  :: value (parent node)
     */
    static class UnionFind {

        int[] root;
        int[] rank;

        public UnionFind() {}

        //FindIfPathExistsInGraphBFS the root node of a given vertex
        //Optimized with path compression IMPORTANT
        public int find(int x) {
            if(x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        //Optimized by union rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public static void main(String[] args) {

        }

    }

}
