package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.topDown;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/featured/card/dynamic-programming/631/strategy-for-solving-dp-problems/4096/
public class StrategicApproachToDp {


    public static void main(String[] args) {
        //1 or 2 steps
        System.out.println(new StrategicApproachToDp().climbStairsMemo(3));
    }

    /*
    Time complexity: O(2n) every call to dp
    creates 2 more calls to dp.
     */
    public int climStairs(int n) {
        return dp(n);
    }

    //A function that represents the answer to the problem for a given state
    private int dp(int i) {
        //Best cases:
        if(i <= 2) return i;
        return
                dp(i - 1)
                +
                dp(i - 2); //Recurrence relation
    }

    private Map<Integer, Integer> memo = new HashMap<>();
    /*
    Memorization
    Time complexity: O(n)
     */
    public int climbStairsMemo(int n) {
        return dpMemo(n);
    }

    private int dpMemo(int i) {
        if(i <= 2) return i;
        //Instead of recursive call, calculate it once
        //by storing inside the hashmap
        if(!memo.containsKey(i)) {
            memo.put(i, dpMemo(i - 1)
                    +
                    dpMemo(i - 2));
        }
        return memo.get(i);
    }


}
