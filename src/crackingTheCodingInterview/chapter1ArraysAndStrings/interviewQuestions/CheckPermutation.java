package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "bbc";
        var obj = new CheckPermutation();
        System.out.println(obj.permutation(s, s1));
    }

    public boolean permutation(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] letters = new int[128];
        char[] s_array = s.toCharArray();
        for(char c : s_array) {
            letters[c]++;
        }
        for(int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if(letters[c] < 0)
                return false;
        }
        return true;
    }
}
