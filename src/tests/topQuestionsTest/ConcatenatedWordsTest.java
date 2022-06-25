package tests.topQuestionsTest;

import java.util.*;

public class ConcatenatedWordsTest {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList(
                "cat","cats","catsdogcats","dog","dogcatsdog","rat"
        ));
        //Output: "catsdogcats","dogcatsdog","ratcatdogcat"
        var obj = new ConcatenatedWordsTest();
        String[] array = new String[words.size()];
        words.toArray(array);
        obj.findAllConcatenatedWordsInADict((array))
                .forEach(e -> System.out.print(e + ", "));
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(words, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        for(int i = 0; i < words.length;  i++) {
            if(compareWords(words[i], set)) {
                result.add(words[i]);
            }
            set.add(words[i]);
        }
        return result;
    }
    private boolean compareWords(String word, Set<String> set) {
        if(set.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(!dp[j]) continue;
                if(set.contains(word.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[word.length()];
    }


}
