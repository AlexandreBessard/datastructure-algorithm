package leetcode.datastructure.arrays101.conclusion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/explore/featured/card/fun-with-arrays/523/conclusion/3231/
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] array = {13, 2, 6, 23, 12};
        //Output 12
        System.out.println(new ThirdMaximumNumber().thirdMax(array));
    }

    /*
    Time complexity: O(N), each value insert into a set for a cost of O(1).
    Never more than 3 elements in the set hence time complexity is 0(1)
    In total we're left with 0(n).
    Space complexity: 0(1), maximums never holds more than 3 items at a time.
     */
    public int thirdMax(int[] nums) {
        Set<Integer> maximums = new HashSet<>();
        for(int num: nums) {
            maximums.add(num);
            if(maximums.size() > 3) {
                maximums.remove(Collections.min(maximums));
            }
        }
        if(maximums.size() == 3) {
            return Collections.min(maximums);
        }
        return Collections.max(maximums);
    }
}
