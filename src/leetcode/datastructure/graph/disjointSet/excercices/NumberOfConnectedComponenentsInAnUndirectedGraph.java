package leetcode.datastructure.graph.disjointSet.excercices;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3911/
class NumberOfConnectedComponentsInAnUndirectedGraph {

    /*
    Approach 2: Disjoint Set Union (DSU)
    Return the number of connected component in the graph.

    Time complexity:
     */
    public int countComponents(int n, int[][] edges) {
        int result = n;
        int[] representative = new int[n];
        int[] size = new int[n];
        for(int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i < edges.length; i++) {
            result -= union(representative, size, edges[i][0], edges[i][1]);
        }
        return result;
    }

    private int find(int[] representative, int vertex) {
        if(representative[vertex] == vertex) {
            return vertex;
        }
        return representative[vertex] = find(representative, representative[vertex]);
    }

    private int union(int[] reprensentative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(reprensentative, vertex1);
        vertex2 = find(reprensentative, vertex2);
        if(vertex1 == vertex2) return 0;
        else {
            if(size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                reprensentative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                reprensentative[vertex1] = vertex2;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        int[][] array = {{0,1},{1,2},{3,4}};
        int[][] array1 = {{0,1},{1,2},{2,3},{3,4}};
        int num = 5;
        System.out.println(new NumberOfConnectedComponentsInAnUndirectedGraph()
                .countComponents(num, array1));
    }
}
