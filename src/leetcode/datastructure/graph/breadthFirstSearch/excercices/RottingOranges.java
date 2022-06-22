package leetcode.datastructure.graph.breadthFirstSearch.excercices;

import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.first;
            int col = p.second;
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty())
                    queue.offer(new Pair(-1, -1));
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }

    static class Pair<U, V> {
        U first;
        V second;
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
        @Override
        // Checks specified object is "equal to" the current object or not
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            // call `equals()` method of the underlying objects
            if (!first.equals(pair.first)) {
                return false;
            }
            return second.equals(pair.second);
        }
        @Override
        // Computes hash code for an object to support hash tables
        public int hashCode()
        {
            // use hash codes of the underlying objects
            return 31 * first.hashCode() + second.hashCode();
        }
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
        // Factory method for creating a typed Pair immutable instance
        public static <U, V> Pair <U, V> of(U a, V b)
        {
            // calls private constructor
            return new Pair<>(a, b);
        }
    }
}
