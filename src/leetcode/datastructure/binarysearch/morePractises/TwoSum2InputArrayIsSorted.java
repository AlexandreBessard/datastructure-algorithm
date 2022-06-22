package leetcode.datastructure.binarysearch.morePractises;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {

    public static void main(String[] args) {
        int[] array = {2,3,4};
        //Output [1, 2] since 2 + 7 = 9
        Arrays.stream(new TwoSum2InputArrayIsSorted().twoSum(array, 6))
                .forEach(e -> System.out.print(e + ", "));
    }

    /*
    Time complexity: O(n) The input array is traversed at most once.
    Space complexity: 0(1). Only additional space for two indices and the sum.
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[] {low + 1, high + 1};
            } else if(sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] {-1, -1};
    }
}
