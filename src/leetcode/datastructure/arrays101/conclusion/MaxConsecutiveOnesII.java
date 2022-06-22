package leetcode.datastructure.arrays101.conclusion;

//https://leetcode.com/explore/featured/card/fun-with-arrays/523/conclusion/3230/
public class MaxConsecutiveOnesII {

    public static void main(String[] args) {
        int[] array = {1,0,1,1,0};
        //Output: 4
        System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(array));
    }

    /*
    Time complexity: 0(N) since both pointers only move forward. Each left and right traverse a maximum of
    n steps.
    Space complexity: 0(1). The space we is use is constant because not correlated to the length of the input array.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int r = 0;
        int l = 0;
        int zero = 0;
        int max = 0;
        while(r < nums.length) {
            if(nums[r] == 0) zero++;
            while(zero == 2) {
                if(nums[l] == 0) {
                    zero--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
