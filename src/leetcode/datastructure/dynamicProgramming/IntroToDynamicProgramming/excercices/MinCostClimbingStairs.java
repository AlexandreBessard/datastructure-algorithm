package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.excercices;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int[] cost2 = {10,15,20};
        System.out.println(new MinCostClimbingStairs()
                .minCostClimbingStairsTopDown(cost2));
    }
    /*
    Bottom-Up (iteration)
    Time complexity: O(N)
    We iterate N - 1 and each iteration we apply an equation that requires O(1) time
    Space complexity: O(N)
    minimumCost array always 1 element longer than array 'cost'
     */
    public int minCostClimbingStairsBottomUp(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int[] minimumCost = new int[cost.length + 1];
        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }
    /*
    Top-Down
    Time complexity: O(N)
    minimumCost gets called with each index 0 to N
    With memoization, each call will only take 0(1) time.
    Space complexity: 0(N)
    because recursion call stack.
     */
    private Map<Integer, Integer> memo = new HashMap<>();
    public int minCostClimbingStairsTopDown(int[] cost) {
        return minimumCost(cost.length, cost);
    }

    private int minimumCost(int i, int[] cost) {
        //best base: start at step 0 or 1
        if(i <= 1) return 0;
        //Check if we have already calculated minimumCost(i)
        if(memo.containsKey(i)) return memo.get(i);
        //If not,cache the result:
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }




}
