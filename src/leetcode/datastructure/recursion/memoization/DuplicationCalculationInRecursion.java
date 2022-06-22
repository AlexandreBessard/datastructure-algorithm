package leetcode.datastructure.recursion.memoization;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1495/
public class DuplicationCalculationInRecursion {

    public static void main(String[] args) {
        //System.out.println(new DuplicationCalculationInRecursion().fibanocci(4));
        System.out.println(new DuplicationCalculationInRecursion()
                .fibanocciBottomUp(4));

    }

    private final Map<Integer, Integer> memo = new HashMap<>();
    /*
    Top-down approach (recursive)
     */
    public int fibanocci(int n) {
        if(n < 2) return n;
        if(memo.containsKey(n)) return memo.get(n);
        int result = fibanocci(n - 1) + fibanocci(n - 2);
        memo.put(n, result);
        return memo.get(n);
    }

    /*
    Bottom-Up approach (iterative)
     */
    public int fibanocciBottomUp(int n) {
        if(n <= 1) return n;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for(int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }
}
