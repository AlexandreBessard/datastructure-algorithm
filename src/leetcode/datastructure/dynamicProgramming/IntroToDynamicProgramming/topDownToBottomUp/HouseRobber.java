package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.topDownToBottomUp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4099/
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        //Ouput: 12
        System.out.println(new HouseRobber().robBottomUp(nums));
    }


    /*
    Top-down solution (recursive)
     */
    public int rob(int[] nums) {
        return dp(nums.length - 1, nums);
    }

    private Map<Integer, Integer> memo = new HashMap<>();
    private int dp(int i, int[] nums) {
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);
        if(!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i- 1, nums), dp(i - 2, nums) + nums[i]));
        }
        return memo.get(i);
    }


    /*
    Transform into bottom-up solution
    *********************************************
     */

    public int robBottomUp(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        //Best cases:
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //Write for loop to iterate over the state variables, starting from the base cases.
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }


}
