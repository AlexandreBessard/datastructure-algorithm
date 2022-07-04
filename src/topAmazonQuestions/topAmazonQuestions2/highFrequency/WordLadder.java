package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        ));
        var obj = new WordLadder();
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
        System.out.println(obj.ladderLengthOptimized(beginWord, endWord, wordList));
    }

    //Approach 2 : Bidirectional BFS
    /*
    Reduce search space
     */
    public int ladderLengthOptimized(String beginWord,
                                     String endWord,
                                     List<String> wordList)
    {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            //Swap
            if(beginSet.size() > endSet.size()) {
                //Reduce look space for neighbors
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for(String word : beginSet) {
                List<String> neighbors = neighbors(word);
                for(String neigh : neighbors) {
                    if(endSet.contains(neigh))
                        return length + 1;
                    if(words.contains(neigh)) {
                        newBeginSet.add(neigh);
                        words.remove(neigh);
                    }
                }
            }
            beginSet = newBeginSet;
            length++;
        }
        return 0;
    }

    //Keep in mind:
    //every adjacent pair words differs by a single letter
    /*
    Approach 1: Breadth Fist Search
    Time complexity:
    M is the length of begin word, N length of the list.
    Call helperMethod once every each words
    O(M^2*N)
    Space complexity: O(M*N) because of N words and each of them side : M
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) {
                    return level;
                }
                List<String> neighbors = neighbors(currentWord);
                for(String neigh: neighbors) {
                    if(words.contains(neigh)) {
                        words.remove(neigh);
                        queue.add(neigh);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> neighbors(String string) {
        char[] chars = string.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }
            chars[i] = temp;
        }
        return result;
    }
}
