package leetcode.datastructure.dynamicProgramming.geekForGeeks.top20DynamicProgramming;

//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class LongestIncreaseSubsequence {

    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        int n = arr.length;
        //Output: 3
        System.out.println(new LongestIncreaseSubsequence()._lis(arr, n));

    }

    /*
    Bottom-up
     */
    public int _lis(int arr[], int n) {
        int[] lis = new int[n];
        for(int i = 0; i < n; i++) {
            lis[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }
        return 0;
    }

}
