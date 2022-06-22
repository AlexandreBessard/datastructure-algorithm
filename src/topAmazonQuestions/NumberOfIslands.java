package topAmazonQuestions;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

    public static void main(String[] args) {
        var obj = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '0', '0'},
                {'1', '0', '1'}
        };
        //4
        //System.out.println(obj.numIslandsDSF(grid2));
        System.out.println();
        System.out.println(obj.numIslandsBFS(grid2));
    }

    /*
    BFS
    if node 1: triggers a BFS
    Put into a Q and set is value to 0 to mark as visited
    Iteratively search the neighbors of enqueued nodes until the Q become empty.


    Check this image for better understanding
    https://imgur.com/gallery/M58OKvB
     */
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                     while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    /*
    DSF
    If node == 1, count 1 island
    and trigger DFS
    Replace node 1 to zero

    Time complexity: O(M x N) where M is the number of Rows and N number of Columns.
    Space complexity: O(M x N) in case that the grid map is filled with lands where DFS goes
    by M x N (if grid contains only 1 as worst case scenario)
    Once node mark as visited, you won't visit again.
     */
    public int numIslandsDSF(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        //Check if we are still inside the 2D array
        if(row >= grid.length || row < 0
        || col >= grid[0].length || col < 0
        || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row, col + 1); // Right
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row - 1, col); // Above
    }


}
