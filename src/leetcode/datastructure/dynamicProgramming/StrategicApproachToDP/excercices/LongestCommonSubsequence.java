package leetcode.datastructure.dynamicProgramming.StrategicApproachToDP.excercices;

//https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4045/
public class LongestCommonSubsequence {


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        //Output: 3
        var obj = new LongestCommonSubsequence();
        System.out.println("Without space optimized: " + obj.longestCommonSubsequence(text1, text2));
        System.out.println("Space optimized: " + obj.longestCommonSubsequencesSpaceOptimization(text1, text2));
    }

    public int longestCommonSubsequencesSpaceOptimization(String test1, String text2) {
        //We always take the smallest String
        //test1 we always be the smallest String
        if(text2.length() < test1.length()) {
            String temp = test1;
            test1 = text2;
            text2 = temp;
        }
        int[] previous = new int[test1.length() + 1];
        //Iterate through each column
        for(int col = text2.length() - 1; col >= 0; col--) {
            //Create array to represent the current column.
            int[] current = new int[test1.length() + 1];
            for(int row = test1.length() - 1; row >= 0; row--) {
                //If same letter
                if(test1.charAt(row) == text2.charAt(col)){
                    current[row] = 1 + previous[row + 1];
                //Not the same letter
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            //The current column becomes the previous one
            previous = current;
        }
        return previous[0];
    }

    public int longestCommonSubsequence(String text1, String text2) {
                // Make a grid of 0's with text2.length() + 1 columns
                // and text1.length() + 1 rows.
                int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];
                // Iterate up each column, starting from the last one.
                for (int col = text2.length() - 1; col >= 0; col--) {
                    for (int row = text1.length() - 1; row >= 0; row--) {
                        // If the corresponding characters for this cell are the same...
                        if (text1.charAt(row) == text2.charAt(col)) {
                            dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
                            // Otherwise they must be different...
                        } else {
                            dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
                        }
                    }
                }
                // The original problem's answer is in dp_grid[0][0]. Return it.
                return dpGrid[0][0];
            }
        }