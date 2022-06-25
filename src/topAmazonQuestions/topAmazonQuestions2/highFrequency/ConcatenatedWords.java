package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.*;

//https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList(
                "cat","cats","catsdogcats","dog","dogcatsdog","rat"
        ));
        //Output: "catsdogcats","dogcatsdog","ratcatdogcat"
        var obj = new ConcatenatedWords();
        String[] array = new String[words.size()];
        words.toArray(array); //Fill the array
        obj.findAllConcatenatedWordsInADict((array))
                .forEach(e -> System.out.print(e + ", "));
    }

    /*
    DP
    Time complexity:
    There are two loops and substring computation.
    Space complexity:
    O(n) length of dp[n]
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        //Increasing length order
        Arrays.sort(words, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        for(int i = 0; i < words.length; i++) {
            if(canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return result;
    }
    private boolean canForm(String word, Set<String> dict) {
        if(dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                //If dp[j] is false -> continue
                if(!dp[j]) continue;
                if(dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }


}
