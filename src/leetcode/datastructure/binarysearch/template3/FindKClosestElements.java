package leetcode.datastructure.binarysearch.template3;

import java.util.ArrayList;
import java.util.List;
//TODO: A revoir, hardcore mais comprehensible

//https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
public class FindKClosestElements {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        new FindKClosestElements()
                .findClosestElements(array, 4, 3)
                .forEach(e -> System.out.print(e + ", "));
    }

    //Binary Search to find the left bound
    /*
    Time complexity: O(log(N - k) + k)
    Space complexity: O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i = left; i < left + k; i++) {
            l.add(arr[i]);
        }
        return l;
    }
}
