package tests.binarySearch;


import leetcode.datastructure.binarysearch.BinarySearch;

public class BinarySearchTest {

    public static void main(String[] args) {
        var obj = new BinarySearchTest();
        int[] array = {-1,0,3,5,9,12};
        //Output: 9
        System.out.println(obj.search(array, 9));

    }

    public int search(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int pivot = left + (right - left)  / 2;
            if(array[pivot] == value) return array[pivot];
            if(array[pivot] < value) {
                //Right side
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

}
