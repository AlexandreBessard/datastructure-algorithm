package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
After all, you can't form a string of 280 unique characters out of a 128-character alphabet.
(see ASCII table: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html)

page 192
 */
public class IsUnique {

    public static void main(String[] args) {
        String s = "alex";
        var obj = new IsUnique();
        System.out.println(obj.isUniqueChars(s));
        System.out.println(obj.isUniqueCharsOptimized(s));
    }
    /*
    Time complexity: O(N) where n is the length of the string.
    But could be O(1). we never iterate through more than 128 characters (ASCII)
    Time complexity: O(1)
     */
    public boolean isUniqueChars(String str) {
        if(str.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val])
                return false;
            else
                char_set[val] = true;
        }
        return true;
    }

    //Reduce our space
    //if we assme we use only letter from 'a' to 'z' only
    public boolean isUniqueCharsOptimized(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            //<< shift a bit pattern to the left
            //test a flag is set uing: &
            if((checker & (1 << val)) > 0){
                return false;
            }
            //We ad a flag
            //|= bitwise inclusive OR and assignment operator   C |= 2 is same as C = C | 2
            checker |= (1 << val);
        }
        return true;
    }
}
