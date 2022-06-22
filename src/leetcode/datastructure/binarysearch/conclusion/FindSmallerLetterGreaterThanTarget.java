package leetcode.datastructure.binarysearch.conclusion;

//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
public class FindSmallerLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char[] letters2 = {'a','b','c','e'};
        char target2 = 'e';
        char target = 'a';
        //Output: 'c'
        System.out.println(new FindSmallerLetterGreaterThanTarget().nextGreatestLetter(letters2, target2));
    }

    /*
    Binary Search:
    Time complexity: O(log N).
    Space complexity: O(1).
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }
}
