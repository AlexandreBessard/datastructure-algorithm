package topAmazonQuestions;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitsOnATruck {

    public static void main(String[] args) {
        int[][] boxTypes = {
                //Num of boxes, NumOfUnits per box
                {1, 3},
                {2, 2},
                {3, 1}};
        //Maximum of number of boxes that can be put on the truck
        //Must not exceed the truckSize
        int truckSize = 4;
        var obj = new MaximumUnitsOnATruck();
        //System.out.println(obj.maximumUnits(boxTypes, truckSize));
        System.out.println(obj.maximumUnitsArraySort(boxTypes, truckSize));
    }



    /*
    Using Array Sort
     */
    public int maximumUnitsArraySort(int[][] boxTypes, int truckSize) {
        //Decreasing order, for increasing order: (a, b) -> a[1] - b[1]
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int unitCount = 0;
        for(int[] boxType: boxTypes) {
            int boxCount = Math.min(boxType[0], truckSize);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if(truckSize == 0) break;
        }
        return unitCount;
    }



    /*
    Brut force

    Time complexity: O(n²) where n is the number of elements
    Space complexity: O(1) we use variables.

     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        int remaningTruckSize = truckSize;
        while(remaningTruckSize > 0) {
            int maxUnitBoxIndex = findMaxUnitBox(boxTypes); //get 0
            //check if boxes are used
            if(maxUnitBoxIndex == -1) break;
            //Find box count that can pe put in the truck
            int boxCount = Math.min(remaningTruckSize, boxTypes[maxUnitBoxIndex][0]);
            unitCount += boxCount * boxTypes[maxUnitBoxIndex][1];
            remaningTruckSize -= boxCount;
            //mark box with index maxUnitBoxIndex as used
            boxTypes[maxUnitBoxIndex][1] = -1;
        }
        return unitCount;
    }

    private int findMaxUnitBox(int[][] boxTypes) {
        int maxUnitBoxIndex = -1;
        int maxUnits = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(boxTypes[i][1] > maxUnits) {
                maxUnits = boxTypes[i][1];
                maxUnitBoxIndex = i;
            }
        }
        return maxUnitBoxIndex;
    }





















}
