package leetcode.datastructure.binarysearch.conclusion;

//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
    }

    /*
    Perfect square:
    1 * 1 = 1
    2 * 2 = 4
    3 * 3 = 9
    4 * 4 = 16
    5 * 5 = 25
    Time complexity: O(log N).
    Space complexity: O(1).
     */
    public boolean isPerfectSquare(int num) {
        int mid, guessedNum;
        int left = 2;
        int right = num / 2;
        while(left <= right) {
            mid = left + (right - left) / 2;
            guessedNum = mid * mid;
            if(guessedNum == num) return true;
            if(guessedNum > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
