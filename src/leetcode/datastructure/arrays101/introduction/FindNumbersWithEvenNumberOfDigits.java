package leetcode.datastructure.arrays101.introduction;

//https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] array = {12,345,2,6,7896};
        System.out.println(new FindNumbersWithEvenNumberOfDigits().findNumbers(array));
    }

    /*
    Time complexity:
    Space complexity: O(1)
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digits = 0;
            int num = nums[i];
            while (num != 0) {
                num /= 10;
                digits++;
            }
            if (digits % 2 == 0) count++;
        }
        return count;
    }
}
