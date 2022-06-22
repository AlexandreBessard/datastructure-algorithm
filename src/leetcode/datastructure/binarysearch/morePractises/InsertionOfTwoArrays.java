package leetcode.datastructure.binarysearch.morePractises;

import java.util.Arrays;
import java.util.HashSet;
//TODO: must be reviewed
//https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1034/
public class InsertionOfTwoArrays {

    public static void main(String[] args) {
        int[] array = {4,9,5};
        int[] array2 = {9,4,9,8,4};
        Arrays.stream(new InsertionOfTwoArrays().intersections1(array, array2))
                .forEach(e -> System.out.print(e + ", "));
    }

    /*

     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>(nums1.length);
        HashSet<Integer> set2 = new HashSet<>(nums2.length);
        for(Integer n : nums1) set1.add(n);
        for(Integer n : nums2) set2.add(n);
        if(set1.size() > set2.size()) return getIntersections(set2, set1);
        else return getIntersections(set1, set2);
    }

    private int[] getIntersections(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for(Integer n : set1) {
            if(set2.contains(n)) output[idx++] = n;
        }
        return Arrays.copyOf(output, idx);
    }

    //Other solution (Binary Search)
    public int[] intersections1(int[] l1, int[] l2) {
        Arrays.sort(l1);
        Arrays.sort(l2);
        int[] intersections = new int[l1.length];
        int l = 0, r = 0;
        int idx = 0;
        while ((Integer)l2[l] != null && (Integer)l1[r] != null) {
       int left = l1[r], right = l2[l];
            if (right == left) {
                intersections[idx++] = right;
                while (left == l1[r]) r++;
                while (right == l2[l]) l++;
                continue;
            }
            if (right > left) while (left == l1[r]) r++;
            else while (right == l2[l]) l++;

        }
        return intersections;
    }
}
