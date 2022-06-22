package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming;

//https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4100/
public class MaxScorePerformMultiplicationOps1770 {

    //Operations start from 0 to (nums.length) - 1
    //Operation number correspond to index from multiplier array
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}, multipliers = {3, 2, 1};
        //Output: 14
        System.out.println(new MaxScorePerformMultiplicationOps1770()
                .maximumScore(nums, multipliers));
    }

    private int[][] memo;
    private int[] nums, multipliers;
    int n, m;
    /*
    Top-down (recursive approach)
     */
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo = new int[m][m];
        return dp(0, 0);
    }

    /*
    left: how many left operations we have done so far
    left: the index of leftmost number remaining in 'nums'
    right: how many right operations
    the index of rightmost number remaining in 'nums'

    Perform m operations, if i equal m we have no operations left.
    i: is like total operation, which means, multiplier[i] is the current multiplier to be used
     */
    private int dp(int i, int left) {
        if(i == m) return 0; //Base case

        //Get multiplier element
        int mult = multipliers[i];
        //Get element from right (nums)
        int right = n - 1 - (i - left);
        //For Java, instead of using a hashmap for the memoization, we will use a 2D array.
        if(memo[i][left] == 0) {
            memo[i][left] = Math.max(
                    mult * nums[left] + dp(i + 1, left + 1), //Pick the left side
                    mult * nums[right] + dp(i + 1, left)); //Pick the right side
        }
        return memo[i][left];
    }
}
