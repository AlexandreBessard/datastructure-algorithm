package leetcode.datastructure.arrays101.inplaceoperations;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        //Ouput: 18,6,6,6,1,-1
        Arrays.stream(Arrays.stream(new ReplaceElementsWithGreatestElementOnRightSide()
                .replaceElements(arr)).toArray()).forEach(
                        e -> System.out.print(e + ", ")
        );
    }

    /*
    Time complexity: O(N)
    Space complexity: 0(1)
     */
    public int[] replaceElements(int[] arr) {
        int mx = -1;
        int a;
        for(int i = arr.length - 1; i >= 0; i--) {
            a = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, a);
        }
        return arr;
    }
}
