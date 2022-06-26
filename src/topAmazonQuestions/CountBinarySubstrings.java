package topAmazonQuestions;

//https://leetcode.com/problems/count-binary-substrings/
public class CountBinarySubstrings {

    public static void main(String[] args) {
        String s = "00110011";
        var obj = new CountBinarySubstrings();
        System.out.println(obj.countBinarySubstring(s));
        System.out.println(obj.countBinarySubstringEasyApproach(s));

    }

    /*
    Approach much easier to understand
     */
    public int countBinarySubstringEasyApproach(String s ){
        //Count substrings like "0011", "01", "1100", "10", "0011", and "01".
        int count = 0;
        //Count number of consecutive 0 or 1 like "00" : 2, "111" : 3 and so on...
        int consecutiveCount = 1;
        //Latest consecutive number (0 or 1)
        int latestConsecutiveCount = 0;
        //Check if same consecutive number (check current and previous)
        for(int i = 1; i < s.length(); i++){
            //Not same number
            if(s.charAt(i) != s.charAt(i - 1)) {
                count++;
                latestConsecutiveCount = consecutiveCount;
                //reset consecutiveCount
                consecutiveCount = 1;
            }
            //Same consecutive number
            else {
                consecutiveCount++;
                if(consecutiveCount <= latestConsecutiveCount) count++;
            }
        }
        return count;
    }


    /*
    Time complexity: O(N), where N  is length of String
    Loop through the input
    Time complexity: O(N) space used by groups array.
     */
    public int countBinarySubstring(String s) {
        int[] groups = new int[s.length()];
        int index = 0;
        groups[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)){
                groups[++index] = 1;
            }else {
                groups[index]++;
            }
        }
        int ans = 0;
        for(int i = 1; i < groups.length; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }

}
