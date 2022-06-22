package tests.dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        var obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    //Top-down
    private int climbStairs(int i, int n, int[] memo) {
        //Base case
        if(i == n) return 1;
        if(i > n) return 0;
        if(memo[i] > 0) return memo[i];
        //Recurrent relation
        int result = climbStairs(i + 1, n, memo) +
                        climbStairs(i + 2, n, memo);
        memo[i] = result;
        return memo[i];
    }



}
