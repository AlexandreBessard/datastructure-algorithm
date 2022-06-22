package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.bottomUp;

//https://leetcode.com/explore/featured/card/dynamic-programming/631/strategy-for-solving-dp-problems/4096/
public class BottomUp {

    /*
    Bottom-up: iteration
     */
    public static void main(String[] args) {
        System.out.println(new BottomUp().climbStairs(5));
    }

    public int climbStairs(int n) {
        if(n == 1) return 1;
        //An array that represents the answer to the problem for a given state
        int[] dp = new int[n + 1];
        dp[1] = 1; //Base cases
        dp[2] = 2; //Base cases
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; //Recurrence relation
        }
        return dp[n];
    }
}
