package leetcode.datastructure.arrays101.inplaceoperations;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/fun-with-arrays/511/in-place-operations/3260/
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        Arrays.stream(new SortArrayByParity().sortArrayByParity(arr))
                .forEach(e -> System.out.print(e + ", "));
        System.out.println();
        System.out.println(2 % 2); // 0
        System.out.println(7 % 2); //1
        System.out.println(16 % 2); // 0
    }

    /*
    Time complexity: O(N) we only need one pass to sort the elements.
    Space complexity: O(1) (in-place)
     */
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while(i < j) {
            if(A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if(A[i] % 2 == 0) i++;
            if(A[j] % 2 == 1) j--;

        }
        return A;
    }
}
