package algorithm;

/*
This is a Java Program to Implement Kadane Algorithm. Kadane algorithm is
to used to obtain the maximum subarray sum from an array of integers.
//https://www.sanfoundry.com/java-program-kadane-algorithm/
 */
public class Kadane {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2};
        var obj = new Kadane();
        System.out.println(obj.maxSequence(nums));
    }

    public int maxSequence(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for(int i = 1; i < arr.length; i++) {
            //calculate maxEndingHere
            if(maxEndingHere < 0) {
                maxEndingHere = arr[i];
            } else {
                maxEndingHere += arr[i];
            }
            //calculate maxSoFar
            if(maxEndingHere >= maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

}
