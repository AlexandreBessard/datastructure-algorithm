package leetcode.datastructure.recursion2.divideAndConquer;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2868/
public class MergeSort {

    /*
    Framework Divide and Conquer
    1 Divide the given unsorted list into several sublists. (Divide)
    2. Sort each of sublists recursively (Conquer)
    3. Merge the sorted sublists to produce new sorted list (Combine)
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2, 8, 7, 6, 4};
        var obj = new MergeSort();
        int[] result = obj.merge_sort(nums);
        for(int i : result) {
            System.out.print(i + ", ");
        }
    }

    /*
    Top-down approach
     */
    public int[] merge_sort(int[] input) {
        if(input.length <= 1) return input;
        int pivot = input.length / 2;
        int[] left_list =
                merge_sort(Arrays.copyOfRange(input, 0, pivot));
        int[] right_list = merge_sort(
                Arrays.copyOfRange(input, pivot, input.length));
        return merge(left_list, right_list);
    }
    private int[] merge(int[] left_list, int[] right_list) {
        int[] ret = new int[left_list.length + right_list.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;
        while(left_cursor < left_list.length
                && right_cursor < right_list.length) {
            if(left_list[left_cursor] < right_list[right_cursor]) {
                ret[ret_cursor++] = left_list[left_cursor++];
            } else {
                ret[ret_cursor++] = right_list[right_cursor++];
            }
        }
        //Append what it is remaining
        while(left_cursor < left_list.length) {
            ret[ret_cursor++] = left_list[left_cursor++];
        }
        while(right_cursor < right_list.length) {
            ret[ret_cursor++] = right_list[right_cursor++];
        }
        return ret;
    }

    /*
    Bottom  Up Approach
    Can be implemented iteratively
     */
    

}