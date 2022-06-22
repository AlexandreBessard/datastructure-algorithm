package leetcode.datastructure.binarysearch.template2;

//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(array));
    }

    /*
    Time complexity: Same as Binary Search O(logN).
    Space complexity: 0(1).
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
