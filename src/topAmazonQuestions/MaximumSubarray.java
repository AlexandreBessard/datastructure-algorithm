package topAmazonQuestions;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public static void main(String[] args) {
        //Look for the highest sum in the array.
        ////Keep counting only in sequence.
        int[] nums = {-2,1,-3,4,-1,2};
        int[] nums2 = {5, -2, 1, -3, 4, -2, 1};
        var obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(nums));
        System.out.println("Divide and Conquer : \n" +
                obj.maxSubArrayDivideAndConquer(nums2));
    }

    /*
    Approach 3: Divide and Conquer
     */
    private int[] numsArray;
    public int maxSubArrayDivideAndConquer(int[] nums) {
        numsArray = nums;
        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length - 1);
    }
    private int findBestSubarray(int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;
        // Iterate from the middle to the beginning.
        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }
        // Reset curr and iterate from the middle to the end.
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }
        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;
        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);
        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }



    /*
    DP: Kadane's Algorithm
    Time complexity: O(N) where N is the length of nums
    Space complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        //start with second element, we already used the first one.
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }

}
