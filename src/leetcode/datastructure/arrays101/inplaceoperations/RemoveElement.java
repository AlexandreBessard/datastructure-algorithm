package leetcode.datastructure.arrays101.inplaceoperations;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/fun-with-arrays/511/in-place-operations/3575/
public class RemoveElement {

    public static void main(String[] args) {
        int[] array = {0,1,2,2,3,0,4,2};
        //Output: 5
        System.out.println(new RemoveElement().removeElement(array, 2));
        Arrays.stream(array).forEach(e -> System.out.print(e + ", "));
    }

    /*
    Time complexity: 0(N). Both i and n traverse at most n steps.
    More efficient if elements to remove are rare.
    Space complexity: 0(1)
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n--;
            }else{
                i++;
            }
        }
        return n;
    }

    /*
    Time complexity: 0(N), both j and i traverse at most 2n steps.
    Space complexity: 0(1).
    //Do unnecessary copy operation.
     */
    public int removeElement1(int[] nums, int val) {
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
