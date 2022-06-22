package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/featured/card/dynamic-programming/631/strategy-for-solving-dp-problems/4146/
public class MaximumScoreFromPerformingMultiplicationOps {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        //Output 14
        var obj = new MaximumScoreFromPerformingMultiplicationOps();
        System.out.println(obj.maximumScore(nums, multipliers));
        //Output 102
        //System.out.println(obj.maximumScore(nums, multipliers));

        //Output: 14
        System.out.println(obj.maximumScoreBottomUp(nums, multipliers));
    }

    int n, m;
    int[] nums, multipliers;
    int[][] memo;
    /*
    Top-down
     */
    public int maximumScore(int[] nums, int[] multipliers) {
        this.n = nums.length;
        this.m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo = new int[m][m];
        return dp(0, 0);
    }

    private int dp(int i, int left) {
        //Base case
        if(i == m) return 0;
        int multi = this.multipliers[i];
        int right = n - 1 - (i - left);
        if(memo[i][left] == 0) {
            //Recurrence relation
            memo[i][left] =
                    Math.max(multi * this.nums[left] + dp(i + 1, left + 1),
                            multi * this.nums[right] + dp(i + 1, left));
        }
        return memo[i][left];
    }

    /*
    Bottom-Up
    dp[i][left] -> represents the max score possible if 'i' operations have
    been performed and 'left' left operations have been performed.
    Time complexity: O(m²) where m is length of multipliers.
     */
    public int maximumScoreBottomUp(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int left = i; left >=0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(
                        mult * this.nums[left] + dp[i + 1][left + 1],
                        mult * this.nums[right] + dp[i + 1][left]);
            }
        }
        return dp[0][0];
    }


}
