package leetcode.datastructure.recursion2.divideAndConquer;

//https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2870/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2, 8, 7, 6, 4};
        var obj = new QuickSort();
        obj.quickSort(nums);
        for(int n : nums) {
            System.out.print(n + ", ");
        }
    }

    /*
    Sort array in ascending order
    Quick sort algo can vary from O(N log² N) in the best case
    and O(N²) in the worst case. (N length of the string)
     */
    public void quickSort(int[] lst) {
        int n = lst.length;
        qSort(lst, 0, n - 1);
    }
    private void qSort(int[] lst, int lo, int hi) {
        if(lo < hi) {
            int p = partition(lst, lo, hi);
            qSort(lst, lo, p - 1);
            qSort(lst, p + 1, hi);
        }
    }
    private int partition(int[] lst, int lo, int hi) {
        int pivot = lst[hi];
        int i = lo;
        for(int j = lo; j < hi; j++) {
            if(lst[j]  < pivot) {
                int tmp = lst[i];
                lst[i] = lst[j];
                lst[j] = tmp;
                i++;
            }
        }
        int tmp = lst[i];
        lst[i] = lst[hi];
        lst[hi] = tmp;
        return i;
    }



}
