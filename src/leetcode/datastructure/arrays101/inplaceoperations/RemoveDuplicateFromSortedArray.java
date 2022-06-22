package leetcode.datastructure.arrays101.inplaceoperations;

//https://leetcode.com/explore/featured/card/fun-with-arrays/511/in-place-operations/3258/
public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicateFromSortedArray().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] > nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
