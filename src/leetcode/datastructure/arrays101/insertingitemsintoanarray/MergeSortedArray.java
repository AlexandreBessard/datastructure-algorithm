package leetcode.datastructure.arrays101.insertingitemsintoanarray;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
public class MergeSortedArray {

    /*
    Time complexity:
    Because each array is already sorted, we can achieve O(n+m)
    time complexity with the help of the two-pointer technique.
    Space complexity: O(1)
    We are not using an extra array.
     */
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(
                e -> System.out.print(e + ", ")
        );
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for(int p = m + n - 1;p >= 0; p--) {
            if(p2 < 0) {
                break;
            }
            if(nums2[p2] >= nums1[p1]) {
                nums1[p] = nums2[p2--];
            } else {
                nums1[p] = nums1[p1--];
            }
        }
    }
}
