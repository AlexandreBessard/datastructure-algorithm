package leetcode.datastructure.arrays101.conclusion;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/fun-with-arrays/523/conclusion/3574/
public class SquareOfASortedArray {

    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};
        Arrays.stream(new SquareOfASortedArray().sortedSquares(array))
                .forEach(e -> System.out.print(e + ", "));
    }
    /*
    Time complexity: O(N) where N is length of A
    Space complexity: 0(N) if you take output into account and O(1) otherwise.
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            int sqare;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                sqare = nums[right];
                right--;
            } else {
                sqare = nums[left];
                left++;
            }
            result[i] = sqare * sqare;
        }
        return result;
    }
}
