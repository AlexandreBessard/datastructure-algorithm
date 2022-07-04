package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        var obj = new StringCompression();
        System.out.println(obj.compressBad(s));
        System.out.println(obj.compressBadStringBuilder(s));
        System.out.println(obj.compressOptimized(s));

    }


    /*
    Optimized in space complexity for the StringBuilder space object allocation.
    One other benefit of this approach is that we can initialize StringBuilder to its necessary capacity
    up-front. Without this, StringBuilder will (behind the scenes) need to double its capacity every time it
    hits capacity. The capacity could be double what we ultimately need.
     */
    public String compressOptimized(String str) {
        int finalLength = countCompression(str);
        if(finalLength >= str.length()) return str;
        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i))
                        .append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }
    private int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                System.out.println(compressedLength);
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }


    public String compressBadStringBuilder(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    /*
    Runtime
    O(p + k²) where p is size of original String
    k number of character sequences
    String concatenation operates in O(n²),
     */
    public String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++) {
            countConsecutive++;
            //If next character is different than current, append this chard to result.
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ?  compressedString : str;
    }


}
