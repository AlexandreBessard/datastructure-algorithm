package training.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int[] cost2 = {1,100,1,1,1,100,1,1,100,1};
        //Output: 15
        //System.out.println(minCostClimbing(cost));
        System.out.println(minBottomUp(cost));
    }

    /*
    Top-down
    Framework:
    1: define state variable
    2: define recurrence relation
    3: define base cases
     */
    private static Map<Integer, Integer> memo = new HashMap<>();
    static int minCostClimbing(int[] cost) {
        return dp(cost.length, cost);
    }
    private static int dp(int i, int[] cost) {
        //Base case
        if(i <= 1) return 0;
        //Check if cache
        if(memo.containsKey(i)) return memo.get(i);
        //Relation recurrence
        int downOne = dp(i - 1, cost) + cost[i - 1];
        int downTwo = dp(i - 2, cost) + cost[i - 2];
        //Put cache
        memo.put(i, Math.min(downOne, downTwo));
        //Get from cache
        return memo.get(i);
    }

    /*
    Bottom-Up (Tabulation)
     */
    //Expected 15
    static int minBottomUp(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int minimumCost[] = new int[cost.length + 1];

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
}
