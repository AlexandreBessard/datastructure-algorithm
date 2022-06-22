package topinterviewquestions.easy.array;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
public class BestTimeToBuyAndSellStockII {

    /*
    Time complexity: O(N). Single pass.
    Space complexity: 0(1). Constant space needed.
     */
    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStockII()
                .maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
