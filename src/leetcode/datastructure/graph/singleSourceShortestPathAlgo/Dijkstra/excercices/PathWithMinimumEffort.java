package leetcode.datastructure.graph.singleSourceShortestPathAlgo.Dijkstra.excercices;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3952/
public class PathWithMinimumEffort {

    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] heights = { {1,2,2},{3,8,2}, {5,3,5 } };
        //Output: 2
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(heights));
    }

    /*
    Dijkstra's Algorithm
    find minimum absolute difference between every adjacent cells
     */
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] differenceMatrix = new int[row][col];
        for (int[] eachRow : differenceMatrix)
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        differenceMatrix[0][0] = 0;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>((a, b) -> (a.difference.compareTo(b.difference)));
        boolean[][] visited = new boolean[row][col];
        queue.add(new Cell(0, 0, differenceMatrix[0][0]));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == row - 1 && curr.y == col - 1)
                return curr.difference;
            for (int[] direction : directions) {
                int adjacentX = curr.x + direction[0];
                int adjacentY = curr.y + direction[1];
                if (isValidCell(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                    int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[curr.x][curr.y]);
                    int maxDifference = Math.max(currentDifference, differenceMatrix[curr.x][curr.y]);
                    //Check previous value from difference matrix
                    if (differenceMatrix[adjacentX][adjacentY] > maxDifference) {
                        differenceMatrix[adjacentX][adjacentY] = maxDifference;
                        queue.add(new Cell(adjacentX, adjacentY, maxDifference));
                    }
                }
            }
        }
        return differenceMatrix[row - 1][col - 1];
    }

    private boolean isValidCell(int x, int y, int row, int col) {
        return (x >= 0)
                && (x <= row - 1)
                && (y >= 0)
                && (y <= col - 1);
    }

    static class Cell {
        int x;
        int y;
        Integer difference;
        Cell(int x, int y, Integer difference) {
            this.x = x;
            this.y = y;
            this.difference = difference;
        }
    }
}
