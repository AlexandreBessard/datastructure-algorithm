package leetcode.datastructure.arrays101.searchingforitemsinanarray;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/explore/featured/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        int[] array = {7,1,14,11};
        System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(array));
    }

    /*
    Time and space complexity: O(N), n = arr.length
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> stack = new HashSet<>();
        for(int i : arr) {
            if(stack.contains(i * 2) || i % 2 == 0 && stack.contains(i / 2)) {
                return true;
            }
            stack.add(i);
        }
        return false;
    }
}
