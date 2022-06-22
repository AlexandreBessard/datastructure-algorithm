package tests.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println("BottomUp: " + new ClimbingStairs()
                .climbStairsBottomUp(3));

    }

    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    private final Map<Integer, Integer> memo = new HashMap<>();
    /*
    Time complexity: O(n) Size of recursion is up to n
    Space complexity: The depth of recursion is up to n
     */
    private int climbStairs(int i, int n) {
        //Base cases
        if(i == n) return 1;
        if(i > n) return 0;
        //Check from cache
        if(memo.containsKey(i)) return memo.get(i);
        //Relation recurrence
        int result = climbStairs(i + 1, n) + climbStairs(i + 2, n);
        //Put into the cache
        memo.put(i, result);
        //Get result from the cache
        return memo.get(i);
    }

    /*
    BottomUp
    Time complexity: O(n) iterative on dp up to n length
    Space complexity: O(n) dp length up to n
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
