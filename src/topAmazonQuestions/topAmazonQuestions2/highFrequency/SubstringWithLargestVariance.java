package topAmazonQuestions.topAmazonQuestions2.highFrequency;

//https://leetcode.com/problems/substring-with-largest-variance/
public class SubstringWithLargestVariance {

    //Explanation of the problem:
    //https://www.youtube.com/watch?v=DbfHIdZL8rQ&ab_channel=CodeWithSunny
    /*
    Example:
    aab : [a : 2 b : 1] -> (2 - 1) == 1 -> variance 1
    aaba : [a 3 b : 1] -> (3 - 1) == 2 -> variance 2
    babbb : [a : 1 b : 4] -> (4 - 1) == 3 -> variance 3
     */
    public static void main(String[] args) {
        String s = "aababbb";
        String s1 = "abbbbb";
        var obj = new SubstringWithLargestVariance();
        System.out.println(obj.largestVariance(s));
    }
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[(int)(s.charAt(i) - 'a')]++;
        }
        int maxVariance = 0;
        for(int a = 0; a < freq.length; a++) {
            for(int b = 0; b < freq.length; b++) {
                int remainingA = freq[a];
                int remainingB = freq[b];
                if(a == b || remainingA == 0 || remainingB == 0) continue;
                //Run Kardanes on each possible characters pairs (A & B)
                int currBFreq = 0, currAFreq = 0;
                for(int i = 0; i < s.length(); i++) {
                    int c = (int) s.charAt(i) - 'a';
                    if(c == b) currBFreq++;
                    if(c == a) {
                        currAFreq++;
                        remainingA--;
                    }
                    if(currAFreq > 0){
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);
                    }
                    if(currBFreq < currAFreq && remainingA >= 1) {
                        currAFreq = 0;
                        currBFreq = 0;
                    }
                }
            }
        }
        return maxVariance;
    }
}
