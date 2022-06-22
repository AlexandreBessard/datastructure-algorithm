package leetcode.datastructure.binarysearch.morePracticises2;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        int[] nums1 = {1,6,1};
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(nums1, 3));
    }

    /*
    Binary Search + Sliding Window

     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while(lo < hi) {
            int mid = (lo + hi) / 2;
        }
        return 0;
    }
}
