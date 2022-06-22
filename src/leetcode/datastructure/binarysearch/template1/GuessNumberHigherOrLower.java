package leetcode.datastructure.binarysearch.template1;

//https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
public class GuessNumberHigherOrLower {
    int pick = 25648;

    public static void main(String[] args) {
        int numberToGuess = 10;
        //Output: 6
        System.out.println(new GuessNumberHigherOrLower().guessNumber(150000));
    }

    private int guess(int mid) {
        if(mid > pick) return -1;
        else if(mid < pick) return 1;
        else return  0;
    }

    //Using BinarySearch
    /*
    Time complexity: O(log2n): Binary Search is used.
    Space complexity: O(1). No extra space is used.
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if(res == 0) return mid;
            if(res < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
