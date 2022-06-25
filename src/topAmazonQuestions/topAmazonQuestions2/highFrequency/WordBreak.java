package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.*;

//https://leetcode.com/problems/word-break/
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(
                        Arrays.asList( "code"));
        String s1 = "catsanddog";
        List<String> wordDict1 = new ArrayList<>(
                Arrays.asList("cats","dog","sand","and","cat"));
        var obj = new WordBreak();
        System.out.println("BFS : " + obj.wordBreakBFS(s, wordDict));
        System.out.println("DP : " + obj.wordBreakDP(s, wordDict));
    }

    /*
    Approach: DP
    Bottom-Up
    Time complexity:
    O(N3) There are two nested loops and substring computation eah iteration.
    Overall O(N3)
    Space complexity:
    O(N) Length of dp
     */
    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordDicSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //Null String is always present in the dictionary
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] &&
                wordDicSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /*
    Approach BFS
    Time complexity: O(N3). For every starting index, the search continue
    till the end of the given String
    Space complexity: O(n). Queue size at most n size.
     */
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while(!queue.isEmpty()) {
            int start = queue.remove();
            /*
            Need this condition below for this case:
            String s = "aaab";
            List<String> l = { "a", "aa", "aaa" }
             */
            if(visited[start]) continue;
            for(int end = start + 1; end <= s.length(); end++) {
                if(wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if(end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }
}
