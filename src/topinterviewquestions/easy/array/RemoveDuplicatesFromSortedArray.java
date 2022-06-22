package topinterviewquestions.easy.array;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
public class RemoveDuplicatesFromSortedArray {

    /*
    Time complexity: O(N). Assume that n is the length of the array.
    Space complexity: O(1). The size of the array stay the same.
     */
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //output: 5
        System.out.println(new RemoveDuplicatesFromSortedArray()
                .removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
