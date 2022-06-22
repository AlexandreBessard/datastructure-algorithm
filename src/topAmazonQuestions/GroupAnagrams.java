package topAmazonQuestions;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        var obj = new GroupAnagrams();
        List<List<String>> result = obj.groupAnagrams(strs);
        for(List<String> r : result){
            System.out.print("[");
            r.forEach(e -> System.out.print(e + " "));
            System.out.print("]\n");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for(String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                //'a' == 97
                //'a' allows you have a value from 0 to 27
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

}
