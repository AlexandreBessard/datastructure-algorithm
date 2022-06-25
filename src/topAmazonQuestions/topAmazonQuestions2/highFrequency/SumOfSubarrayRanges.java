package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiPredicate;

//https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubarrayRanges {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        var obj = new SumOfSubarrayRanges();
        System.out.println(obj.subArraySum(nums));
    }

    /*
    Simple Method 1
    Solution: https://www.geeksforgeeks.org/sum-of-all-subarrays/
     */
    public long subArraySum(int[] nums){
        int n = nums.length;
        long result = 0, temp = 0;
        for(int i = 0; i < n; i++) {
            temp = 0;
            for(int j = i; j < n; j++) {
                temp += nums[j];
                result += temp;
            }
        }
        return result;
    }

}
