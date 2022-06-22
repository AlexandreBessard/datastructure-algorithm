package leetcode.datastructure.dynamicProgramming.geekForGeeks.top20DynamicProgramming;

//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
public class LongestCommonSubsequence {


    /*
    LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
    A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
    For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
     */
    public static void main(String[] args) {
        //String s1 = "AGGTAB", s2 = "GXTXAYB";
        //String X = "AXYT", Y = "AYZX";
        String X = "AB", Y = "BC";
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0; i < m + 1; i++){
            for(int j=0; j < n + 1; j++){
                dp[i][j] = -1;
            }
        }
        //Output: 2
        System.out.println(lcs(X, Y, m, n, dp));
    }

    /*
    Top-down implementation
    With memoization
     */
    static int lcs(String X,String Y,int m,int n,int[][] dp){
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if(X.charAt(m - 1) == Y.charAt(n - 1)){
            dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
            return dp[m][n];
        }
        dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),lcs(X, Y, m - 1, n, dp));
        return dp[m][n];
    }



}
