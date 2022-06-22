package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/featured/card/dynamic-programming/631/strategy-for-solving-dp-problems/4097/
public class HouseRobber198 {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] nums2 = {1,2,3,1};
        int[] nums4 = {1, 2, 3};
        int[] nums3 = {2, 1, 1, 2};
        var obj = new HouseRobber198();
        //System.out.println("Bottom Up : \n" + obj.robBottomUp(nums));
        System.out.println("Bottom Up Test: \n" + obj.robBottomTest(nums3));
        System.out.println(obj.robToDown(nums4));
    }

    /*
    Framework:
    1: Define state variable (i)
    2: Recurrence relation
    3: Base cases
    TOP-DOWN
     */
    private Map<Integer, Integer> memo = new HashMap<>();
    private int[] nums;
    public int robToDown(int[] nums) {
        this.nums = nums;
        return dpTopDown(nums.length - 1);
    }

    private int dpTopDown(int i) {
        //Best cases:
        //Only one house, then the most money we can make is by robbing the house
        if(i == 0) return nums[0];
        //If there are 2 houses, the most money we can make is by robbing
        //the house with the most money (we have to choose between them)
        if(i == 1) return Math.max(nums[0], nums[1]);
        if(!memo.containsKey(i)) {
            memo.put(i,
                    Math.max(
                            dpTopDown(i - 1),
                            dpTopDown(i - 2) + nums[i]));
        }
        return memo.get(i);
    }

    /*
    BOTTOM-UP
     */
    public int robBottomUp(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        //best cases
        //rob from 0 house
        dp[0] = nums[0];
        //0 house to the first house
        dp[1] = Math.max(nums[0], nums[1]);
        //i = 2 because we have resolved O and 1
        for(int i = 2; i < nums.length; i++) {
            //Calculate the max at the next step
            //dp[i] is the max of robbed in the current house index.
            dp[i] = Math.max(
                    //get the money house between the first and third
                    dp[i - 1],
                    //current house + the current max we can get (i - 2)
                    //dp[i - 2] represents the maximum of money
                    //i - 2 because we do not want trigger the police
                    //Robbing the current house + max money from the previous two houses ago
                    dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }


    public int robBottomTest(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        //No houses
        dp[0] = 0;
        //First house is 1 if [1, 2, ... n]
        //Current house's money
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            //calculate max at the next step
            dp[i + 1] = Math.max(
                    //Check the current max
                    dp[i],
                    // the old max (previous max) + the new house (current element)
                    //The old max will be a house away
                    dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }

}
