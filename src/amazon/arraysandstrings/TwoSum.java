package amazon.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/
public class TwoSum {

    public static void main(String[] args) {
        int[] array = {2,7,7,15};
        Arrays.stream(new TwoSum().twoSum(array, 14))
                .forEach(e -> System.out.print(e + ", "));
    }

    /*
    Time complexity: O(n). We traverse the list only once.
    Space complexity: O(n). extra space required depends on the items stored in the hashtable.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
