package leetcode.datastructure.graph.disjointSet.excercices;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/
public class NumberOfProvinces {

    //isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    /*
    1  1  0
    1  1  0   We have 2 provinces
    0  0  1
     */

    public static void main(String[] args) {
        int[][] arr = { {1,1,0}, {1,1,0}, {0,0,1} };
        System.out.println(new NumberOfProvinces().findCircleNum(arr));
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        /*
        Node:          0   1   2
        parent Node:  -1  -1  -1
        Whose own parent parent is given -1 (since we do not have any connection with other node for now)
         */
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }
}
