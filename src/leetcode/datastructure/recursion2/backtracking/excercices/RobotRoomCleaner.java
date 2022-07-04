package leetcode.datastructure.recursion2.backtracking.excercices;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/robot-room-cleaner/
public class RobotRoomCleaner {

    /**
     * // This is the robot's control interface.
     * // You should not implement it, or speculate about its implementation
     * interface Robot {
     *     // Returns true if the cell in front is open and robot moves into the cell.
     *     // Returns false if the cell in front is blocked and robot stays in the current cell.
     *     public boolean move();
     *
     *     // Robot will stay in the same cell after calling turnLeft/turnRight.
     *     // Each turn will be 90 degrees.
     *     public void turnLeft();
     *     public void turnRight();
     *
     *     // Clean the current cell.
     *     public void clean();
     * }
     */

    interface Robot {
        //True if cell in front is open and robot moves into the cell.
        boolean move();
        //False if the cell in front is blocked and robot stays in the current cell.
        void turnLeft();
        void turnRight();
        void clean();
    }

    public static void main(String[] args) {
        int[][] room = {
                {1,1,1,1,1,0,1,1},
                {1,1,1,1,1,0,1,1},
                {1,0,1,1,1,1,1,1},
                {0,0,0,1,0,0,0,0},
                {1,1,1,1,1,1,1,1}
        };
        int row = 1, col = 3;
        var obj = new RobotRoomCleaner();
        obj.cleanRoom(new Robot() {
            @Override
            public boolean move() {
                return false;
            }
            @Override
            public void turnLeft() {
            }
            @Override
            public void turnRight() {
            }
            @Override
            public void clean() {
            }
        });
    }
    //CLock wise, up, right, down, left
    int[][] directions = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;
    /*
    Spiral Backtracking
    Time complexity: O(N - M) where N is a number of cells in the room
    M number of obstacles
    Space complexity: O(N - M) where N number of cells & M is a number of obstacles.
     */
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    //d means direction
    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newD);
                goBack();
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    private void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    static class Pair<U, V> {
        U first;
        V second;
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            if(!first.equals(pair.first)) {
                return false;
            }
            return second.equals(pair.second);
        }
        @Override
        public int hashCode() {
            return 31 * first.hashCode() + second.hashCode();
        }
    }
}
