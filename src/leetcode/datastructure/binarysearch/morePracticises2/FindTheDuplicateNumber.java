package leetcode.datastructure.binarysearch.morePracticises2;

//TODO: need to be reviewed
//https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] array = {1,3,4,2,2};
        int[] array2 = {1, 2, 4, 2, 1, 5};
        int[] array3 = {1, 2, 3, 4};
        //Output 2 since it is the duplicated number
        System.out.println(new FindTheDuplicateNumber().findDuplicate(array3));
    }

    /*
    Binary Search

     */
    public int findDuplicate(int[] nums) {
        //high and low represents the range of values of the target
        int low = 1, high = nums.length - 1;
        int duplicate = -1;
        while(low <= high) {
            int cur = low + (high - low)/ 2;
            //Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for(int num: nums) {
                if (num <= cur) {
                    count++;
                }
            }
                if(count > cur){
                    duplicate = cur;
                    high = cur - 1;
                } else {
                    low = cur + 1;
                }

        }
        return duplicate;
    }
}
