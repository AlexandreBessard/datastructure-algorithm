package leetcode.datastructure.binarysearch.morePractises;

//https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1033/
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
    }

    /*
    Does not care about the rotation. Apply simply the Binary Search.
    Time complexity: O(log N). (Binary Search)
    Space complexity: 0(1).
     */
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        //Array already sorted
        if(nums[right] > nums[left]) return nums[0];
        int mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid + 1] > nums[mid] && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else {
                if(nums[0] > nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
