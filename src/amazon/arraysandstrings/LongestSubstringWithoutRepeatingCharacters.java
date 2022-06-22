package amazon.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    //Given a string s, find the length of the longest substring without repeating characters.
    public static void main(String[] args) {

        var abba = "abcba";
        System.out.println(lengthOfLongestSubstring(abba));

    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, len = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) >= start) {
                    start = map.get(c) + 1;
                }
            }
            len = Math.max(len, (i - start) + 1);
            map.put(c, i);
        }
        return len;
    }




}
