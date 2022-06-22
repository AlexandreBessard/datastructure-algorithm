package leetcode.datastructure.binarysearch.morePractises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InsertionOfTwoArrays2 {

    public static void main(String[] args) {
        //Ouput: [2, 2]
        int[] array = {1,2,2,1};
        int[] array2 = {2, 2};
        //Output: [4, 9]
        int[] array3 = {4,9,5};
        int[] array4 = {9,4,9,8,4};
        Arrays.stream(new InsertionOfTwoArrays2().intersect1(array3, array4))
                .forEach(e -> System.out.print(e + ", "));
    }

    //Approach 1: HashMap (if non sorted)
    /*
    Time complexity: O(n + m) where n and m are the lengths of the arrays.
    We iterate through the first, and then through the second array.
    Insert a lookup operations in the hashMap take a constant time.
    Space complexity: O(min(n, m)). We use hashMap to store numbers (and their counts)
    from the smaller array.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for(int n : nums2) {
            int i = map.getOrDefault(n, 0);
            if(i > 0) {
                nums1[k++] = n;
                map.put(n, i - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    //If sorted:
    /*
    Time complexity: 0(n log n + m log m), where n and m are the length of the arrays.
    We sort 2 arrays independently and then do a linear scan.
    Space complexity: O(log n + log m) to O(n + m) For the complexity analysis purpose, we ignore
    the memory required by inputs and outputs.
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            }else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
