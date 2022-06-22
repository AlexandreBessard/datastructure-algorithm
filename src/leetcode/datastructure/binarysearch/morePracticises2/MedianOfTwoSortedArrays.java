package leetcode.datastructure.binarysearch.morePracticises2;

//TODO: Need to be reviewed. Tough question.
//Link solution just below:
//https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation?page=5
//https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new MedianOfTwoSortedArrays()
                .findMedianSortedArrays(num1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if(N1 > N2) return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = 2 * N1;
        while(lo <= hi) {
            int C1 = (lo + hi) / 2; //3
            int C2 = N1 + N2 - C1;
            double L1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1-1)/2];
            double R1 = (C1 == 2*N1) ? Integer.MAX_VALUE : nums1[C1/2];
            double L2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2-1)/2];
            double R2 = (C2 == 2*N2) ? Integer.MAX_VALUE : nums2[C2/2];
            //Not completed...
        }
        return 0.0;
    }
}
