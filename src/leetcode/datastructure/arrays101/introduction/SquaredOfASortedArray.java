package leetcode.datastructure.arrays101.introduction;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3240/
public class SquaredOfASortedArray {

    /*
    Time complexity: O(N) where N is the length of the array.
    Space complexity: O(N) if you take output into account and O(1) otherwise.
     */
    public static void main(String[] args) {

        int[] array = {-4,-1,0,3,10};
        Arrays.stream(new SquaredOfASortedArray().sortedSquares(array))
                .forEach(e -> System.out.print(e + ", "));
    }

    public int[] sortedSquares(int[] nums) {
        int square;
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[right + 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else  {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}
