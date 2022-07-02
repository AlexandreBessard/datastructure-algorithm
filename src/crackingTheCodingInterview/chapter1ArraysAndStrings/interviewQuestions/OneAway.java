package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
 */
public class OneAway {

    public static void main(String[] args) {
        String s1 = "palze", s2 = "pale";
        var obj = new OneAway();
        System.out.println(obj.oneEditAway(s1, s2));
        System.out.println(obj.oneEditAwayOptimized(s1, s2));
    }

    public boolean oneEditAwayOptimized(String first, String second) {
        //Length checks
        if(Math.abs(first.length() - second.length()) > 1)
            return false;
        //Get shorter string stored in s1 variable
        final String s1 = first.length() < second.length() ? first : second;
        final String s2 = first.length() < second.length() ? second : first;
        int index1 = 0, index2 = 0;
        boolean foundDifference = false;
        while(index2 < s2.length() && index1 < s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                //Ensure that is the first difference found
                if(foundDifference) {
                    return false;
                }
                foundDifference = true;
                if(s1.length() == s2.length()) { //On replace
                    index1++;
                }
            } else {
                index1++; //If matching move shorter pointer;
            }
            index2++; //Always move pointer for longer string
        }
        return true;
    }


    /*
    Time complexity: O(n) where n is the length of the shorter string.
     */
    public boolean oneEditAway(String first, String second) {
        if(first.length() == second.length()) {
            return oneEditReplace(first, second);
            //Deletion
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
            //Insertion
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }
    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0, index2 = 0;
        while(index2 < s2.length()
                && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if(index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                //More than 1 letter, return false.
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }


}
