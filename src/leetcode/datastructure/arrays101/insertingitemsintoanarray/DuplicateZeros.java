package leetcode.datastructure.arrays101.insertingitemsintoanarray;

import java.util.Arrays;
//TODO: A revoir !!! Difficile mais comprehensible
//https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] array = {1,0,2,3,0,4,5,0};
        //output: {1,0,0,2,3,0,0,4};
        Arrays.stream(new DuplicateZeros().duplicateZeros(array)).forEach(
                e -> System.out.print(e + ", ")
        );
    }

    public int[] duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // FindIfPathExistsInGraphBFS the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }
        for(int i = length_ - possibleDups; i >= 0; i--) {
            if(arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
        return arr;
    }
}
