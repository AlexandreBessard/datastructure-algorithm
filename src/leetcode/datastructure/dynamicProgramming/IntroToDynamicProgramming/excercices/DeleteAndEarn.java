package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.excercices;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4147/
public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        //Output: 9
        System.out.println(new DeleteAndEarn().deleteAndEarnBottomUpSpaceOptimized(nums));
    }

    /*
    Top-down (recursion)
     */
    private Map<Integer, Integer> points = new HashMap<>();
    private Map<Integer, Integer> cache = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        //Precompute how many points we gain from taking an element
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        return maxPoints(maxNumber);
    }

    private int maxPoints(int num) {
        //Check for cases:
        if(num == 0) return 0;
        if(num == 1) return points.getOrDefault(1, 0);
        if(cache.containsKey(num)) return cache.get(num);
        //Apply recurrence relation
        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        return cache.get(num);
    }

    /*
    Bottom-up
     */
    public int deleteAndEarnBottomUp(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        //Precompute.
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        //Declare array along with base cases:
        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);
        for(int num = 2; num < maxPoints.length; num++) {
            //Apply recurrence relation
            int gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain);
        }
        return maxPoints[maxNumber];
    }

    /*
    Bottom-Up space optimized
     */
    public int deleteAndEarnBottomUpSpaceOptimized(int[] nums) {
        int maxNumber = 0;
        Map<Integer, Integer> points = new HashMap<>();
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        //Base cases:
        int twoBack = 0;
        int oneback = points.getOrDefault(1, 0);
        for (int num = 2; num <= maxNumber; num++) {
            int temp = oneback;
            oneback = Math.max(oneback, twoBack + points.getOrDefault(num, 0));
            twoBack = temp;
        }
        return oneback;
    }
}
