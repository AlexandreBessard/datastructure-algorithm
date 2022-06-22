package leetcode.datastructure.arrays101.searchingforitemsinanarray;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {0,3,4,2    ,1};
        //Output: true
        System.out.println(new ValidMountainArray().validMountainArray(arr));
    }

    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;
        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;
        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;
        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;
        return i == N-1;
    }
}
