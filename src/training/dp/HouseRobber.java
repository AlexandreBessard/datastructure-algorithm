package training.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        //Output: 4
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2,7,9,3,1};

        System.out.println(robBottomUp(nums));
    }

    /*
    Top-down (recursive)
     */
    static int robTown(int[] houses) {
        return dp(houses.length - 1, houses);
    }
    private static Map<Integer, Integer> map = new HashMap<>();
    /*
    First, must decide on state variable.
    i : indicates the index of house
     */
    private static int dp(int i, int[] houses) {
        //Best cases: (knows when to stop)
        if(i == 0) return houses[0]; //Only one house (take profit from this house)
        /*
        Third: Best cases
        There is 2 houses, robb the house with more money (since we have
        to choose between them)
         */
        if(i == 1) return Math.max(houses[0], houses[1]);

        if(map.containsKey(i)) return map.get(i);

        /*
        Second: Recurrence relation
        From these 2 options, we always want to pick the one
        that gives us maximum profits.
         */
        int result = Math.max( //Recurrence relation
          dp(i - 1, houses), //Decide not to rob this house
          dp(i - 2, houses) + houses[i] //Decide to rob this house
        );
        map.put(i, result);
        return map.get(i);
    }

    /*
    Bottom-Up
     */
    static int robBottomUp(int[] nums) {
        int[] dp = new int[nums.length];
        //best cases:
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
