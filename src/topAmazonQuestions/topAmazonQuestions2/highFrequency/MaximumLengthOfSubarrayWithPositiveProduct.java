package topAmazonQuestions.topAmazonQuestions2.highFrequency;

public class MaximumLengthOfSubarrayWithPositiveProduct {


    /*
    We know that:
    positive_number * positive_number is positive,
    positive_number * negative_number is negative,
    negative_number * negative_number is positive.
     */
    public static void main(String[] args) {
        int[] nums = {1,-2,-3,4};
        int[] nums2 = {0,1,-2,-3,-4};
        var obj = new MaximumLengthOfSubarrayWithPositiveProduct();
        System.out.println(obj.getMaxLen(nums2));
    }

    public int getMaxLen(int[] nums) {
        int positive = 0;
        int negative = 0;
        int ans = 0;
        for(int x : nums) {
           if(x == 0) {
               positive = 0;
               negative = 0;
           } else if(x > 0) {
               positive++;
               negative = negative == 0 ? 0 : negative++;
           } else {
               //Negative num
               int temp = positive;
               positive = negative ==  0 ? 0 : negative + 1;
               negative = temp + 1;
           }
           ans = Math.max(ans, positive);
        }
        return ans;
    }
}
