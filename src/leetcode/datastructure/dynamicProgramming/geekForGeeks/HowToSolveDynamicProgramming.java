package leetcode.datastructure.dynamicProgramming.geekForGeeks;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
public class HowToSolveDynamicProgramming {

    /*
    Given 3 numbers {1, 3, 5}, we need to tell
    the total number of ways we can form a number 'N'
    using the sum of the given three numbers.
    (allowing repetitions and different arrangements).
     */
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5};
        //Output: 8
        System.out.println(solve(6));
    }

    /*
    Top-down
     */
    private static Map<Integer, Integer> memo = new HashMap<>();
    static int solve(int n) {
        //Base cases:
        if(n < 0) return 0;
        if(n == 0) return 1;
        //Check from cache
        if(memo.containsKey(n)) return memo.get(n);
        //Relation recurrence
        int result = solve(n - 1) + solve(n - 3) + solve(n - 5);
        //Put cache
        memo.put(n, result);
        //Get cache
        return memo.get(n);
    }
}
