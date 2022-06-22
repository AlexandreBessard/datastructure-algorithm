package amazon.sortingAndSearching;

import java.util.PriorityQueue;
import java.util.Random;

//https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/482/
public class KthLargestElementInAnArray {

    int[] nums;

    public static void main(String[] args) {

        int[] array = {3,2,1,5,6,4};
        //Output 5, it is the second (2) largest element of that list
        //System.out.println(new KthLargestElementInAnArray().findKthLargest(array, 2));
        int[] array2 = {1, 2, 3, 4};
        System.out.println(new KthLargestElementInAnArray().findKthLargestQuickSelect(array2, 4));

    }

    /*
    Keep in mind:
    A PriorityQueue is used when the objects are supposed to be processed based on the priority.
    Element are sorted inside the heap (poll) fetch the first element of the heap (index 0).
     */
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    /*
    QuickSelect
        //! Please notice that this algorithm works well even for arrays with duplicates.
     */
    public int findKthLargestQuickSelect(int[] nums, int k) {
        if(k > nums.length) throw new IndexOutOfBoundsException();
        this.nums = nums;
        int size = nums.length;
        return quickSelect(0, size - 1, size - k);
    }

    private int quickSelect(int left, int right, int k_smallest) {
        if(left == right) return this.nums[left];
        int pivot = left + new Random().nextInt(right - left);
        int partition = partition(left, right, pivot);
        if(partition == k_smallest) return this.nums[partition];
        else if(partition > k_smallest) {
            //left
            return quickSelect(left, partition - 1, k_smallest);
        }else {
            //right
            return quickSelect(partition + 1, right, k_smallest);
        }
    }

    private int partition(int left, int right, int pivot_index) {
        int loc = left;
        int pivot = this.nums[pivot_index];
        //swap pivot to the right
        swap(pivot_index, right);
        for(int i = left; i <= right; i++) {
            if(this.nums[i] < pivot) {
                swap(loc, i);
                loc++;
            }
        }
        swap(loc, right);
        return loc;
    }

    public void swap(int pivot, int right) {
        int tmp = this.nums[pivot];
        this.nums[pivot] = this.nums[right];
        this.nums[right] = tmp;
    }

}
