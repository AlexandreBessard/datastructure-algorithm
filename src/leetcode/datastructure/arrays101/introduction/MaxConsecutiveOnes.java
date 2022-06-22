package leetcode.datastructure.arrays101.introduction;

//https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] array = {1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes()
                .findMaxConsecutiveOnes(array));
    }

    /*
    Time complexity: O(N) where N is the number of elements in the array.
    Space complexity: O(1). We do not use extra space.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count += 1;
            }else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }

}
