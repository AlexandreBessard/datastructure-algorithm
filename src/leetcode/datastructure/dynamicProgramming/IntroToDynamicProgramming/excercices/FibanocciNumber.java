package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.excercices;

import java.util.HashMap;
import java.util.Map;

public class FibanocciNumber {

    public static void main(String[] args) {
        System.out.println(fibannociNumTopDown(5));
        System.out.println(fibannociNumBottomUp(5));
    }


    /*
    Bottom-Up
     */
    static int fibannociNumBottomUp(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }



    /*
    Top-down
     */
    static int fibannociNumTopDown(int n) {
        return dp(n);
    }
    private static Map<Integer, Integer> memo = new HashMap<>();
    private static int dp(int i) {
        //Base case
        if(i <= 1) return i;
        //Check if in cache
        if(memo.containsKey(i)) return memo.get(i);
        //Relation recurrence
        int result = dp(i - 1) + dp(i - 2);
        //Put cache
        memo.put(i, result);
        //return cache
        return memo.get(i);
    }

}
