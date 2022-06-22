package leetcode.datastructure.binarysearch.template3;

//https://leetcode.com/explore/learn/card/binary-search/135/template-iii/946/
public class FindPeakElement {

    public static void main(String[] args) {
        int[] array = {1,2,3,1};
        //Output index: 2
        System.out.println(new FindPeakElement().findPeakElement(array));
    }

    /*
    Time complexity: O(log2(n)). We reduce the search space in half at every step. 'n' refers
    to the size of nums array.
    Space complexity: 0(1). Constant extra space is used.
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
