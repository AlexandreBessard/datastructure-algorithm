package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=f2xi3c1S95M
public class MinimumStepsToMinimizeNto1 {

    //Return minimum steps to minimize n to 1
    /*
    - Available steps:
    -> Decrement n by 1.
    -> If n is divisible by 2, then divide n by 2.
    -> If n is divisible by 3, then divide n by 3.
    Examples: 10 -> 3 steps (10 => 9 => 3 => 1)
    15 -> (15 => 5 => 4 => 2 => 1)
     */
    public static void main(String[] args) {
        int n = 6;
        //System.out.println(getMinStepsMemo(n, new int[n+1]));
        System.out.println(getMinStepsTab(10000));
    }

    /*
    Bottom-Up
     */
    static int getMinStepsTab(int n) {
        int[] table = new int[n + 1];
        Arrays.fill(table, n);
        table[1] = 0;
        for(int i = 1; i < n; i++) {
            table[i + 1] = Math.min(table[i+1], table[i] + 1);
            if(i * 2 <= n)
                table[i * 2] = Math.min(table[i * 2], table[i] + 1);
            if(i * 3 <= n)
                table[i * 3] = Math.min(table[i * 3], table[i] + 1);
        }
        return table[n];
    }




    /*
    Top-down with memoized
     */
    static int getMinStepsMemo(int n, int[] memo) {
        //Best case:
        if(n == 1) return 0;
        if(memo[n] != 0) {
            return memo[n];
        }
        int result = getMinStepsMemo(n - 1, memo);
        if(n % 2 == 0){
            result = Math.min(result, getMinStepsMemo(n/2, memo));
        }
        if(n % 3 == 0) {
            result = Math.min(result, getMinStepsMemo(n/3, memo));
        }
        memo[n] = result + 1;
        return memo[n];
    }

    /*
    Top-down
     */
    static int getMinSteps(int n) {
        //Best case:
        if(n == 1) return 0;
        int result = getMinSteps(n - 1);
        if(n % 2 == 0){
            result = Math.min(result, getMinSteps(n/2));
        }
        if(n % 3 == 0) {
            result = Math.min(result, getMinSteps(n/3));
        }
        return result + 1;
    }











    static int getMinStepsBottomUpTest(int n) {
        int[] table = new int[n + 1];
        table[1] = 0;
        Arrays.fill(table, n);
        for(int i = 1; i < n; i++) {
            table[i + 1] = Math.min(table[i + 1], table[i] + 1);
            if(i * 2 <= n)
                table[i * 2] = Math.min(table[i * 2], table[i] + 1);
            if(i * 3 <= n)
                table[i * 3] = Math.min(table[i * 3], table[i] + 1);
        }
        return table[n];
    }



    /*
    TEST
    Top-Down, memoized version
     */
    private static Map<Integer, Integer> map = new HashMap<>();
    static int getMinStepsTest(int n) {
        if(n == 1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int result = getMinSteps(n - 1);
        if(n % 2 == 0) {
            result = Math.min(getMinStepsTest(n / 2), result);
        }
        if(n % 3 == 0) {
            result = Math.min(getMinStepsTest(n / 3), result);
        }
        map.put(n, result + 1);
        return map.get(n);
    }
    //OR with array
    static int getMinStepsTestArray(int n, int[] array) {
        if(n == 1) return 0;
        int result = getMinStepsTestArray(n - 1, array);
        if(n % 2 == 0) Math.min(getMinStepsTestArray(n / 2, array), result);
        if(n % 3 == 0) Math.min(getMinStepsTestArray(n / 3, array), result);
        array[n] = result + 1;
        return array[n];
    }




}
