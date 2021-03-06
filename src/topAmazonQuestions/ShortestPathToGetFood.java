package topAmazonQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-to-get-food/
//Solution:
//https://leetcode.com/problems/shortest-path-to-get-food/discuss/1127459/JAVA-BFS-Clean-Solution
public class ShortestPathToGetFood {

    public static void main(String[] args) {
        char[][] grid = {
                {'X','X','X','X','X','X'},
                {'X','*','O','O','O','X'},
                {'X','O','O','#','O','X'},
                {'X','X','X','X','X','X'}
        };
        var obj = new ShortestPathToGetFood();
        System.out.println(obj.getFood(grid));
    }

    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    /*
    O(V + E) E represents neighbor (edges)
    V: number of elements in the 2d array
    Space complexity: O(V) Q will be at most O(V) space.
     */
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(findStart(grid));
        boolean[][] visited = new boolean[m][n];
        int step=0;
        while(!q.isEmpty()){
            for(int i=0; i < q.size(); i++){
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                if(grid[x][y] == '#') return step + 1;
                for(int[] dir: dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(isValid(grid, newX, newY) && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private int[] findStart(char[][] grid){
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException();
    }
    private boolean isValid(char[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 'X';
    }
}
