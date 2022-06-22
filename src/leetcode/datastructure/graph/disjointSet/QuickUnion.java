package leetcode.datastructure.graph.disjointSet;
//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3840/
/*
Space complexity: O(N) space to store the array of size N
 */
public class QuickUnion {

    static class UnionFind {
        private int[] root;

        /*
        Time complexity: O(N)
         */
        public UnionFind(int size) {
            root = new int[size];
            for(int i = 0; i < root.length; i++) {
                this.root[i] = i;
            }
        }

        //Time complexity: O(N)
        //Retrieve value if vertex and parent vertex is the same
        public int find(int x) {
            while(x != this.root[x]) {
                x = this.root[x];
            }
            return x;
        }

        //Time complexity: O(N)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                this.root[rootY] = rootX;
            }
        }

        //Time complexity: O(1)
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public static void main(String[] args) {
            UnionFind uf = new UnionFind(10);
            // 1-2-5-6-7 3-8-9 4
            //means 2 is going to be connected to the parent vertex 1
            uf.union(1, 2);
            //means 5 vertex is going to be connected to the parent vertex 1 (since 2 is connected to 1, see above)
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
            uf.union(3, 8);
            uf.union(8, 9);
            System.out.println(uf.connected(1, 5)); // true
            System.out.println(uf.connected(5, 7)); // true
            System.out.println(uf.connected(4, 9)); // false
            // 1-2-5-6-7 3-8-9-4
            uf.union(9, 4);
            System.out.println(uf.connected(4, 9)); // true
        }

    }

}
