package leetcode.datastructure.arrays101.deletingitemsfromanarray;

//https://leetcode.com/explore/featured/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
public class RemoveElement {


    public static void main(String[] args) {
        int[] array = {0,1,2,2,3,0,4,2};
        //Output 5
        System.out.println(new RemoveElement().removeElement(array, 2));
    }

    /*
    Time complexity: O(N) Assume the array has a total of n elements both i and j traverse
    at most 2n steps.
    Space complexity: O(1)
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
