package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public class StringRotation {

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        var obj = new StringRotation();
        System.out.println(obj.isRotation(s1, s2));
    }

    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        //Check that s1 and s2 are equal length and not empty
        if( len > 0 && len == s2.length()) {
            //Concatenate s1 and s1 within new buffer
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        int indexS1 = 0, indexS2 = 0, res = 0;
        while(indexS1 < s1.length() && indexS2 < s2.length()) {
            if(s1.charAt(indexS1) != s2.charAt(indexS2)){
                indexS1++;
            } else {
                res++;
                indexS1++;
                indexS2++;
            }
        }
        return res == s2.length();
    }
}
