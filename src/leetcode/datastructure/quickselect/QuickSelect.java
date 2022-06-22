package leetcode.datastructure.quickselect;

//https://www.geeksforgeeks.org/quickselect-algorithm/
public class QuickSelect {

    public static void main(String[] args) {
        int[] array2  = {15, 10, 4, 3, 20, 7};
        int[] array3 = {4, 3, 7};
        int k = 2;
        //k-th smallest element in an unordered list
        //Output 7
        //System.out.println(quickSelect(array2, k));
        System.out.println(quickSelect(array3, 2));
    }

    /*
    QuickSelect
    Time complexity: O(n)
    Space complexity: 0(n) : recursion stack space
     */
    public static int quickSelect(int[] array, int k) {
        if(k > array.length)
            throw new IndexOutOfBoundsException("k must be equal or lower than array length");
        return select(array, 0, array.length - 1, k);
    }

    private static int select(int[] array, int low, int high, int kPosition) {
        int parition = findPartition(array, low, high);
        if(parition == kPosition - 1) {
            return array[parition];
        } else if(parition > kPosition - 1) {
            //left
            return select(array, low, parition - 1, kPosition);
        } else {
            //right
            return select(array, parition + 1, high, kPosition);
        }
    }

    private static int findPartition(int[] array, int low, int high) {
        int pivotLoc = low;
        for(int i = low; i <= high; i++) {
            if(array[i] < array[high]) {
                int temp = array[i];
                array[i] = array[pivotLoc];
                array[pivotLoc] = temp;
                pivotLoc++;
            }
        }
        int temp = array[high];
        array[high] = array[pivotLoc];
        array[pivotLoc] = temp;
        return pivotLoc;
    }

}
