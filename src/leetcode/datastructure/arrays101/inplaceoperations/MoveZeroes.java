package leetcode.datastructure.arrays101.inplaceoperations;

//https://leetcode.com/explore/featured/card/fun-with-arrays/511/in-place-operations/3157/
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        //Ouput: 1,3,12,0,0
        for(int i : nums) {
            System.out.print(i + ", ");
        }
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        //acts as a flag to check if a 0 has been encountered
        //j will always have the position of value 0
        int j = -1;
        int i = 0;
        while(i < n) {
            //first occurence of 0
            if(nums[i] == 0 && j == -1) j = i;
            //has zero in the array before a valid digit, hence swap
            //only change the value when it is not equal to zero
            //j != -1 means, we have zero somewhere in the array
            else if(nums[i] != 0 && j != -1) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
            i++;
        }
    }
}
