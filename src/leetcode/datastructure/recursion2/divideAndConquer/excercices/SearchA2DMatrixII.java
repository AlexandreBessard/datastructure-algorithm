package leetcode.datastructure.recursion2.divideAndConquer.excercices;

//https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
public class SearchA2DMatrixII {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
        };
        int target = 19;
        var obj = new SearchA2DMatrixII();
        System.out.println(obj.searchMatrix(matrix, target));
    }
    private int[][] matrix;
    private int target;
    /*
    Divide and Conquer Approach
    For a sorted two-dimensional array
     */
    private boolean searchRec(int left, int up, int right, int down) {
        //Down is the row, up is the row, left = column, right = column
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }
        int mid = left + (right-left)/2;
        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }
    public boolean searchMatrix(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
}
