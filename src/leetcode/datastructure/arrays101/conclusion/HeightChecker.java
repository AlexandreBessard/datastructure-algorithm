package leetcode.datastructure.arrays101.conclusion;

public class HeightChecker {

    public static void main(String[] args) {
        int[] array = {1,1,4,2,1,3};
        //Output: 3
        System.out.println(new HeightChecker().heightChecker(array));
        //Ex: { 1,1,4,2,1,3 }
        //Index 0:  the 0 is represented 0 times in the array (0)
        //Index 1: the 1 is represented 3 times in the array. (3)
        //Index 2: the 4 is represented 1 time in the array (1)
        //and so on....
        //{ 0, 3, 1, 1, 1 }
    }

    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for(int h : heights) {
            heights[h]++;
        }
        int result = 0;
        int curr = 0;
        for(int i = 0; i < heights.length; i++) {
            while(freq[curr] == 0) {
                curr++;
            }
            if(curr != heights[i]) {
                result++;
            }
            freq[curr]--;
        }
        return result;
    }
}
