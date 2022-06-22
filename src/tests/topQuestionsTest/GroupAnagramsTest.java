package tests.topQuestionsTest;
import java.util.*;

public class GroupAnagramsTest {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        var obj = new GroupAnagramsTest();
        List<List<String>> result = obj.groupAnagrams(strs);
        for(List<String> r : result){
            System.out.print("[");
            r.forEach(e -> System.out.print(e + " "));
            System.out.print("]\n");
        }
    }

    /*
    Time complexity: O(NK) where N is the length of str
    K is the max length of a string in N
    Space complexity: O(NK) the total information content stored in map
     */
    public List<List<String>> groupAnagrams(String[] str) {
        if(str == null || str.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for(String s :str) {
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append("#").append(count[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
