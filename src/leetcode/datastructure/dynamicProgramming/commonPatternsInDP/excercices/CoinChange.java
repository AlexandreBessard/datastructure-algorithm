package leetcode.datastructure.dynamicProgramming.commonPatternsInDP.excercices;

//https://leetcode.com/explore/learn/card/dynamic-programming/632/common-patterns-in-dp-problems/4111/
public class CoinChange {

    public static void main(String[] args) {
        var obj = new CoinChange();
        int[] coins = {1, 2};
        int amount = 3;
        //Output 3
        System.out.println(obj.coinChange(coins, amount));
    }

    /*
    Dynamic Programming (Top-Down)
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

}
