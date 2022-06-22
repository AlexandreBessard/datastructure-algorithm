package leetcode.datastructure.dynamicProgramming.StrategicApproachToDP.excercices;

//https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4046/
public class MaximalSquare {

    public static void main(String[] args) {
        var obj = new MaximalSquare();
        char[][] c = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        //Output 4:
        System.out.println(obj.maximalSquare(c));
        System.out.println("Space complexity reduced :\n" +
                obj.maximalSquareSpaceComplexityReduced(c));
    }


    public int maximalSquareSpaceComplexityReduced(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(
                            Math.min(dp[j - 1], prev),
                    dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    /*
    Dynamic Programming
    Time complexity: O(mn). Single pass
    Space complexity: O(mn). Another matrix of same size is used
    for dp
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(
                            //First element to get the min value
                            Math.min(dp[i][j - 1], dp[i - 1][j])
                            //Second element to get the min value
                            , dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }



}
