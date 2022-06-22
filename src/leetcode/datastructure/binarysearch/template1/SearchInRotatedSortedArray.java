package leetcode.datastructure.binarysearch.template1;

//https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = {4,5,6,7,8,1,2,3};
        int[] array2 = {5,1,2};
        int[] array3 = {4, 5, 6, 3}; //target 3
        //Output: 4
        System.out.println(new SearchInRotatedSortedArray().search(array2, 5));
    }

    /*
    Time complexity: O(LogN)
    Space complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;

            //Pivot element is larger than the first element in the array
            else if(nums[mid] >= nums[start]) {

                if(target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;

            }
            //Pivot element is smaller than the first element of the array
            else {

                if(target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;

            }
        }
        return -1;
    }





    public int search1(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) return mid;
            else if(array[mid] > array[left]) {
                if(target >= array[left] && target < array[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if(target <= array[right] && target > array[mid])
                    left = mid + 1;
                else
                    left = mid - 1;
            }
        }
        return 0;
    }







}
