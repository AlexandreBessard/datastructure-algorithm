package leetcode.datastructure.dynamicProgramming.excercices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
public class PascaleTriangle2 {

    public static void main(String[] args) {
        //Output: [1, 3, 3, 1]
        //System.out.println(new PascaleTriangle2().getRow(3));
        System.out.println(new PascaleTriangle2().getRowMemoryEfficient(3));

    }


    /*
    Approach 3: Memory-efficient Dynamic Programming
     */
    public List<Integer> getRowMemoryEfficient(int rowIndex) {
        List<Integer> rows = new ArrayList<>(rowIndex + 1);
        rows.add(1);
        for(int i = 0; i < rowIndex; i++) {
            for(int j = i; j > 0; j--) {
                rows.set(j, rows.get(j) + rows.get(j - 1));
            }
            rows.add(1);
        }
        return rows;
    }



    private final Map<RowCol, Integer> cache = new HashMap<>();
    /*
    Approach 2: Dynamic Programming
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }
        return ans;
    }

    private int getNum(int row, int col) {
        RowCol rowCol = new RowCol(row, col);
        if(cache.containsKey(rowCol)) return cache.get(rowCol);
        int computedVal = (row == 0 || col == 0 || row == col)
                        ? 1
                        : getNum(row - 1, col - 1) + getNum(row - 1, col);
        cache.put(rowCol, computedVal);
        return computedVal;
    }

    static class RowCol {
        private int row, col;
        RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            int result = (int) (row ^ (row >>> 32));
            return (result << 5) - 1 + (int) (col ^ (col >>> 32)); // 31 * result == (result << 5) - 1
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;

            RowCol rowCol = (RowCol) o;
            return row == rowCol.row && col == rowCol.col;
        }

    }
}
