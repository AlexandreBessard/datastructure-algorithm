package tests.quickselect;

public class QuickSelectTest {

    public static void main(String[] args) {
        var obj = new QuickSelectTest();
        int[] nums = {4, 3, 7};
        int k = 1;
        //Output 4:
        System.out.println(obj.quickSelect(nums, 1));
    }

    public int quickSelect(int[] nums, int k) {
        if(k > nums.length) throw new IndexOutOfBoundsException("k must be equal or less than nums array");
        return select(0, nums.length - 1, nums, k);
    }

    public int select(int low, int high, int[] nums, int k) {
        int pivot = findPivot(nums, 0, high);
        if(pivot == k - 1) return nums[pivot];
        //Check the left side
        else if(pivot > (k - 1)) {
            return select(low, pivot - 1, nums, k);
        }
        //Check right side
        else {
            return select(pivot + 1, high, nums, k );
        }
    }

    private int findPivot(int[] nums, int low, int high) {
        int pivot = low;
        for(int i = low; i <= high; i++) {
            if(nums[i] < nums[high]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                pivot++;
            }
        }
        int temp = nums[high];
        nums[high] = nums[pivot];
        nums[pivot] = temp;
        return pivot;
    }


}
