package tests.topQuestionsTest;

import java.util.Arrays;

public class KClosestPointsToOriginTest {

    public static void main(String[] args) {
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k = 2;
        var obj = new KClosestPointsToOriginTest();
        int[][] result = obj.kClosest(points, k);
        for(int[] i : result) {
            System.out.print("[");
            for(int j : i) {
                System.out.print(j + ",");
            }
            System.out.print(']');
            System.out.println();
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length;
        int partition = k + 1;
        while(k != partition) {
            int part = partition(points, k, left, right);
            if(k < part) {
                left = part;
            } else {
                right = part + 1;
            }
        }
        return Arrays.copyOf(points, k);
    }

    public int partition(int[][] points, int k, int left, int right) {
        int pivot = getPivot(left, right);
        int squareFromPivot = squareFromPivot(points[pivot]);
        while(left < right) {
            if(squareFromPivot(points[left]) >= squareFromPivot) {
                int[] temp = points[pivot];
                points[pivot] = points[left];
                points[left] = temp;
                right--;
            } else {
                left++;
            }
        }
        if(squareFromPivot(points[left]) < pivot) {
            left++;
        }
        return left;
    }

    private int squareFromPivot(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }

    private int getPivot(int left, int right) {
        return left + (right - left) / 2;
    }



}
