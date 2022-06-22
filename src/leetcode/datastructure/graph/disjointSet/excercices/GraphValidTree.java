package leetcode.datastructure.graph.disjointSet.excercices;

//https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3910/
public class GraphValidTree {
    private int[] parent;
    private int[] size; // We use this to keep track of the size of each set.

    public GraphValidTree() {}

    // For efficiency, we aren't using makeset, but instead initialising
    // all the sets at the same time in the constructor.
    public GraphValidTree(int n) {
        parent = new int[n];
        size = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            size[node] = 1;
        }
    }

    public static void main(String[] args) {
        int num = 5;
        int[][] arr = {{0,1},{0,2},{0,3},{1,4}};
        //Does not work because array from 0 to 4 if num = 5
        //int[][] arr3 = {{0,1},{0,6},{0,3},{1,4}};
        int[][] arr2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(new GraphValidTree().validTree(num, arr2));
    }

    // The find method, with path compression. There are ways of implementing
    // this elegantly with recursion, but the iterative version is easier for
    // most people to understand!
    public int find(int A) {
        // Step 1: FindIfPathExistsInGraphBFS the root.
        int root = A;
        while (parent[root] != root) {
            root = parent[root];
        }
        // Step 2: Do a second traversal, this time setting each node to point
        // directly at A as we go.
        while (A != root) {
            //Use as example to understand:
            //0  1  2  :: node
            //0  0  1 :: parent node
            int oldRoot = parent[A];
            parent[A] = root;
            A = oldRoot;
        }
        return root;
    }

    // The union method, with optimization union by size. It returns True if a
    // merge happened, False if otherwise.
    public boolean union(int A, int B) {
        // FindIfPathExistsInGraphBFS the roots for A and B.
        int rootA = find(A);
        int rootB = find(B);
        // Check if A and B are already in the same set.
        if (rootA == rootB) {
            return false;
        }
        // We want to ensure the larger set remains the root.
        if (size[rootA] < size[rootB]) {
            // Make rootB the overall root.
            parent[rootA] = rootB;
            // The size of the set rooted at B is the sum of the 2.
            size[rootB] += size[rootA];
        }
        else {
            // Make rootA the overall root.
            parent[rootB] = rootA;
            // The size of the set rooted at A is the sum of the 2.
            size[rootA] += size[rootB];
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {

        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;

        // Condition 2: The graph must contain a single connected component.
        // Create a new UnionFind object with n nodes.
        GraphValidTree unionFind = new GraphValidTree(n);
        // Add each edge. Check if a merge happened, because if it
        // didn't, there must be a cycle.
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!unionFind.union(A, B)) {
                return false;
            }
        }
        // If we got this far, there's no cycles!
        return true;
    }
}
