package topAmazonQuestions;

public class CountBinarySubstrings {

    public static void main(String[] args) {
        String s = "00110011";
        var obj = new CountBinarySubstrings();
        System.out.println(obj.countBinarySubstring(s));
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
