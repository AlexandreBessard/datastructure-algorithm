package leetcode.datastructure.graph.disjointSet;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3846/
public class LeetCode547NumberOfProvinces {
        int[] root;
        int[] rank;
        int count;

        public LeetCode547NumberOfProvinces(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for(int i = 0; i < size; i++) {
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }

        public int find(int x) {
            //Same value
            if(x == root[x]) {
                return x;
            }
            //change the value to the original array.
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if(rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        public static int findCircleNum(int[][] isConnected) {
            if(isConnected == null && isConnected.length == 0)
                return 0;
            int n = isConnected.length;
            LeetCode547NumberOfProvinces uf = new LeetCode547NumberOfProvinces(n);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.count;
        }

    public static void main(String[] args) {
        //Size of 3
        int[][] array =  { {1,1,0},{1,1,0},{0,0,1} };
        //Expected 2 provinces
        System.out.println(findCircleNum(array));
    }

}
