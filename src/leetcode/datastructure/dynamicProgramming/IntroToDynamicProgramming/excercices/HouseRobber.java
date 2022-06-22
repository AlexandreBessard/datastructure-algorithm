package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.excercices;

public class HouseRobber {

    public static void main(String[] args) {
        int[] houses = {2,7,9,3,1};
        //Output: 12
        //System.out.println(new HouseRobber().robOptimized(houses));
        System.out.println(new HouseRobber()
                .testOptimized(houses));
    }



    /*
    TEST
    Bottom-Up
    Time complexity: O(N), we loop from N - 2 .... 0
    Space complexity: O(N), because we create an array dp of N + 1 length
     */
    public int test(int[] arr) {
        int N = arr.length;
        if(N == 0) return 0;
        int[] dp = new int[N + 1];
        dp[N] = 0;
        dp[N - 1] = arr[N - 1];
        for(int i = N - 2; i >= 0; i--) {
            dp[i] = Math.max(
              dp[i + 1], dp[i + 2] + arr[i]
            );
        }
        return dp[0];
    }

    //DP optimized space complexity to O(1)
    public int testOptimized(int[] arr) {
        int N = arr.length;
        if(N == 0) return 0;
        int robPlusOne = 0; //1
        int rob = arr[N - 1];
        for(int i = N - 2; i >= 0; i--) {
            int current =
                    Math.max(
                            rob, robPlusOne + arr[i]
                    );
            robPlusOne = rob;
            rob = current;
        }
        return rob;
    }
    /*
    END TEST
     */





    /*
    Dynamic Programming
    Time complexity: O(N) since we have a loop from N - 2 .... 0
    Space complexity: O(N) which is used by the table
     */
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 0) return 0;
        int[] maxRobbedAmount = new int[N + 1];
        //Base case initialisation
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];
        //DP table calculations;
        for(int i = N - 2; i >= 0; i--) {
            //Recursive solution
            maxRobbedAmount[i] = Math.max(
                    maxRobbedAmount[i + 1],
                    maxRobbedAmount[i + 2] + nums[i]);
        }
        return maxRobbedAmount[0];
    }

    /*
    Optimized Dynamic Programming for space complexity
     */
    public int robOptimized(int[] nums) {
        int N = nums.length;
        if(N == 0) return 0;
        int robNextPlusOne = 0;
        int robNext = nums[N - 1];
        for(int i = N - 2; i >= 0; i--) {
            int current = Math.max(
                    robNext,
                    robNextPlusOne + nums[i]
            );
            //Update the variables:
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }


}
