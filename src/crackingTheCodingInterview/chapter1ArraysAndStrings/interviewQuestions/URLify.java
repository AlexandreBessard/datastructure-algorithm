package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"
 */
public class URLify {

    public static void main(String[] args) {
        String s = "Mr John Smith                     ";
        int realNumCharacters = 13;
        var obj = new URLify();
        //obj.replaceSpaces(s, realNumCharacters);
        System.out.println(obj.replaceSpaces(s, realNumCharacters));
    }

    //We can use this algo because we have a buffer at the end of the string.
    public String replaceSpaces(String s, int trueLength) {
        char[] str = s.toCharArray();
        int spaceCount = 0;
        int index, i = 0;
        for(int j = 0; j < trueLength; j++) {
            if(str[j] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if(trueLength < str.length) {
            str[trueLength] = '\0'; //End of array
        }
        for(i = trueLength - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return new String(str);
    }

}
