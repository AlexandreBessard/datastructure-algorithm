package leetcode.datastructure.binarysearch;

//https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
public class BinarySearch {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array = {-1,0,3,5,9,12};
        //Output: 9
        var obj = new BinarySearch();
        System.out.println(obj.search(array, 9));
        System.out.println(obj.binarySearch(array1, 1));
    }

    /*
    Time complexity: O(logN): The equation represents dividing a problem up into
    a subproblems.
    Space complexity: O(1) constant space solution
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pivot;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] > target) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }


    /*
    Other example same as above but with different template.
     */
    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }

}
