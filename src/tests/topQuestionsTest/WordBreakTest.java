package tests.topQuestionsTest;

import java.util.*;

public class WordBreakTest {

    public static void main(String[] args) {
        String s  = "catsanddog";
        String s1 = "totdog";
        String s2 = "applepenapple";
        String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict3 = new ArrayList<>(
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        List<String> wordDict2 = new ArrayList<>(Arrays.asList("apple", "pen", "apple"));
        List<String> wordDict1 = new ArrayList<>(Arrays.asList("dog"));
        List<String> worDict = new ArrayList<>(
                Arrays.asList("cats", "dog", "sand", "and", "dog")
        );
        var obj = new WordBreakTest();
        String s4 = "leetcode";
        List<String> list4 = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println("DP => " + obj.wordBreakDP(s4, list4));
        System.out.println("BFS : " + obj.wordBreakBFS(s4, list4));
    }

    /*
    BFS
     */
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int start = 0;
        boolean[] visited = new boolean[s.length()];
        while(!q.isEmpty()) {
            start = q.poll();
            if(visited[start]) continue;
            for(int end = start + 1; end <= s.length(); end++) {
                if(words.contains(s.substring(start, end))) {
                    if(end == s.length()) return true;
                    q.add(end);
                }
                visited[start] = true;
             }
        }
        return false;
    }

    /*
    DP
     */
    public boolean wordBreakDP(String s, List<String> wordDic) {
        Set<String> words = new HashSet<>(wordDic);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i ; j++) {
                if(words.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
