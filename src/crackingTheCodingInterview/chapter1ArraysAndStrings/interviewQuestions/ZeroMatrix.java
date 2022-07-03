package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

public class ZeroMatrix {

    /*
    Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
    its entire row and
    column are set to 0.
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
        };
        var obj = new ZeroMatrix();
    }

    //Non optimized
    /*
    Space complexity: O(N)
     */
    public void setZerosNonOptimized(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        //Store the row and column index with value 0
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[i] = true;
                }
            }
        }
        //Nullify rows
        for(int i = 0; i < row.length; i++) {
            if(row[i]) {
                nullifyRow(matrix, i);
            }
        }
        //Nullify columns
        for(int j = 0; j < column.length; j++) {
            if(column[j]) {
                nullyfyColumn(matrix, j);
            }
        }
    }
    private void nullyfyColumn(int[][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
    private void nullifyRow(int[][] matrix, int row) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }


    //Optimized
    /*
    Space complexity: O(1)
    Keep in mind, we resolve this issue:
        if we come
       across other cells in that row or column,
       we'll see the zeros and change their row and column to zero. Pretty
        soon, our entire matrix will be set to zeros
     */
    public void setZeros(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;
        //Check if first row has zero
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }
        //Check if first column has zero
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }
        //Check for zeros in the rest of the array
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //Nullify rows based on values in the firs column
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                //next chunk of code looks the same as the earlier code but using rows.
                nullifyRow(matrix, i);
            }
        }
        //Nullify columns based on values in the firs row
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                nullifyRow(matrix, j);
            }
        }

        //Nullify first row
        if(rowHasZero){
            nullifyRow(matrix, 0);
        }
        //Nullify first column
        if(colHasZero) {
            nullyfyColumn(matrix, 0);
        }
    }
}
