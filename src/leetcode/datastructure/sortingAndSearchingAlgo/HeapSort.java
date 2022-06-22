package leetcode.datastructure.sortingAndSearchingAlgo;

//https://www.geeksforgeeks.org/heap-sort/
public class HeapSort {

    /*
    This one is a must to know
     */

    public void sort(int arr[]) {
        int n = arr.length;
        //Build heap
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //One by one extract an element from heap
        for(int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if(left < n && arr[left] > arr[largest])
            largest = left;
        if(right < n && arr[right] > arr[largest])
            largest = right;
        if(largest != i) {
            //swap
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = i;
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }
}
