package topAmazonQuestions;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        var obj = new KClosestPointsToOrigin();
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int[][] points1 = {
                {1, 3},
                {-2, 2}
        };
        int[][] result = obj.kClosest(points, 1);
        for (int[] i : result) {
            System.out.println();
            for (int l : i) {
                System.out.print(l + ",");
            }
        }
    }

    /*
    Time complexity: O(N), worst case scenario: O(N²) if the worst pivot is chosen each time.
    Space complexity: O(1) No recursion. Constant extra space.
     */
    private int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            // Repeatedly partition the array
            // while narrowing in on the kth element
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                //right
                left = pivotIndex;
            } else {
                //left
                right = pivotIndex - 1;
            }
        }
        // Return the first k elements of the partially sorted array
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = choosePivot(points, left, right);
        int pivotDist = squaredDistance(pivot);
        while (left < right) {
            // Iterate through the range and swap elements to make sure
            // that all points closer than the pivot are to the left
            //Smallest element on the left based on pivot value
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        // Ensure the left pointer is just past the end of
        // the left range then return it as the new pivotIndex
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }

    private int[] choosePivot(int[][] points, int left, int right) {
        // Choose a pivot element of the array
        return points[left + (right - left) / 2];
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
