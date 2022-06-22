package leetcode.datastructure.arrays101.deletingitemsfromanarray;

//https://leetcode.com/explore/featured/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        //Output: 5
        System.out.println(new RemoveDuplicateFromSortedArray().removeDuplicates(array));
    }

    /*
    Time complexity: O(N), 'n' is the length of array. Each of i and j traverses at most 'n' steps
    Space complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
