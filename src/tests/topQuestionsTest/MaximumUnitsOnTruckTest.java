package tests.topQuestionsTest;

public class MaximumUnitsOnTruckTest {

    public static void main(String[] args) {
        int[][] boxTypes = {
                //Num of boxes, NumOfUnits per box
                {1, 3},
                {2, 2},
                {3, 1}};
        //Maximum of number of boxes that can be put on the truck
        //Must not exceed the truckSize
        int truckSize = 4;
        var obj = new MaximumUnitsOnTruckTest();
        System.out.println(obj.maxUnits(boxTypes, truckSize));
    }

    public int maxUnits(int[][] boxTypes, int truckSize) {
        int numOfUnits = 0;
        while(truckSize > 0) {
            int maxUnitsIndex = findMaxUnits(boxTypes);
            //If all boxes have been loaded
            if(boxTypes[maxUnitsIndex][1] == -1) break;
            int boxes = Math.min(boxTypes[maxUnitsIndex][0], truckSize);
            numOfUnits += boxes * boxTypes[maxUnitsIndex][1];
            truckSize -= boxes;
            boxTypes[maxUnitsIndex][1] = -1;
        }
        return numOfUnits;
    }

    private int findMaxUnits(int[][] boxTypes) {
        int maxOfUnits = 0;
        int indexWithMaxOfUnits = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(boxTypes[i][1] > maxOfUnits) {
                maxOfUnits = boxTypes[i][1];
                indexWithMaxOfUnits = i;
            }
        }
        return indexWithMaxOfUnits;
    }
}
