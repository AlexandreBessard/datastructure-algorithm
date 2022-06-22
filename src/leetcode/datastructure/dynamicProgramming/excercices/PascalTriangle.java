package leetcode.datastructure.dynamicProgramming.excercices;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

    public static void main(String[] args) {
        /*
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
         */
        new PascalTriangle().generate(5)
                .forEach(e -> System.out.print(e + ", "));
    }

    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> triangle = new ArrayList<>();
       triangle.add(new ArrayList<>());
       triangle.get(0).add(1);
       for(int r = 1; r < numRows; r++) {
           List<Integer> currRows = new ArrayList<>();
           List<Integer> prev = triangle.get(r - 1);
           currRows.add(1);
           for(int col = 1; col < prev.size(); col++) {
               currRows.add(prev.get(col - 1) + prev.get(col));
           }
           currRows.add(1);
           triangle.add(currRows);
       }
        return triangle;
    }
}
