package leetcode.datastructure.recursion.memoization.excercices;

//https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
public class ClimbingStairs {

    public static void main(String[] args) {
        //Output: 3
        System.out.println(new ClimbingStairs()
                .climbStairs(3));
        System.out.println("Bottom-Up: \n" + new ClimbingStairs()
                .climbStairsBottomUp(6));
    }

    /*
    Top-down
    Time  complexity: O(n) Size of recursion tree can go up to n.
    Space complexity O(n): The depth of recursion tree can  go up to n.
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(0, n , memo);
    }

    private int climbStairs(int i, int n, int[] memo) {
        if(i > n) return 0;
        if(i == n) return 1;
        if(memo[i] > 0) return memo[i];
        int result = climbStairs(i + 1, n, memo)
                +
                climbStairs(i + 2, n, memo);
        memo[i] = result;
        return memo[i];
    }

    /*
    Bottom-up Dynamic programming:
    Time complexity: O(n) Single loop up to n
    Space complexity: 0(n) dp array of size n is used
     */
    public int climbStairsBottomUp(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



}
