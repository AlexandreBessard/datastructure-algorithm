package leetcode.datastructure.arrays101.conclusion;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/explore/featured/card/fun-with-arrays/523/conclusion/3270/
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] array = {3,3,2,1,4,5,6,4};
        //Expected: 4, 6
        new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(array)
                .forEach(e -> System.out.print(e + ","));
    }

    /*
    Time complexity: O(N).
    Space complexity: 0(1) since we are using the input array itself as a hash table and
    the space occupied by the output array doesn't count toward the space complexity
    of the algorithm.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> l = new LinkedList<>();
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                l.add(i);
            }
        }
        return l;
    }
}
