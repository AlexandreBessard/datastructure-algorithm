package leetcode.datastructure.binarysearch.morePractises;

//https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1031/
public class FindMinimumInSortedArray2 {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 2};
        int[] array2 = {1, 3, 3}; //lower += 1 skip the correct answer
        //Output: 0
        System.out.println(new FindMinimumInSortedArray2().findMin(array));
    }

    /*
    Binary Search
     */
    public int findMin(int[] nums) {
        int low = 0;
        int right = nums.length - 1;
        while(low < right) {
            int mid = low + (right - low) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else if(nums[mid] > right) {
                low = mid + 1;
            } else {
                right -= 1;
            }
        }
        return low;
    }
}
