package leetcode.datastructure.binarysearch.template3;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
public class SearchForARange {

    public static void main(String[] args) {
        int[] array1 = {5,7,7,8,8,10};
        int target1 = 8, target2 = 6;
        int[] array2 = {5,7,7,8,8,10};
        Arrays.stream(new SearchForARange()
                .searchRange(array1, target1))
                .forEach(e -> System.out.print(e + ", "));
    }

    /*
    Time complexity: O(LogN), N elements in the array. Each steps, we discard half of
    the array. We simply perform binary search twice in this case.
    Space complexity: O(1), we only use space for a few variables.
     */
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = findBound(nums, target, true);
        if(firstOccurence == -1) return new int[] {-1, -1};
        int secondOccurence = findBound(nums, target, false);
        return new int[] {firstOccurence, secondOccurence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int begin = 0, end = nums.length - 1;
        while(begin <= end) {
            int mid = begin + (end - begin) / 2;
            if(nums[mid] == target) {
                if(isFirst) {
                    if(mid == begin || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if(end == mid || nums[mid + 1] != target) {
                        return mid;

                    } else {
                        begin = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
