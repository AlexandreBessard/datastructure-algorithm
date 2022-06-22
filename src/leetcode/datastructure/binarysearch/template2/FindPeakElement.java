package leetcode.datastructure.binarysearch.template2;

//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
public class FindPeakElement {

    public static void main(String[] args) {
        int[] array = {1,2,3,1};
        int[] array2 = {1, 4, 1};
        int[] array3 = {1,2,1,3,5,6,4};
        System.out.println(new FindPeakElement().findPeakElement(array3));
    }

    /*
    Time complexity: O(log2(n)). We reduce the search space in half at every step.
    Space complexity: O(log2(n)), the depth of recursion tree will go up to log2(n).
     */
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if(l == r) return l;
        int mid = l + (r - l) / 2;
        if(nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }
}
