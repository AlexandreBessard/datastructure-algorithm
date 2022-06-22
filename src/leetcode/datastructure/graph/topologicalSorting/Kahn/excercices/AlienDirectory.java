package leetcode.datastructure.graph.topologicalSorting.Kahn.excercices;

import java.util.*;

//https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3909/
class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        String[] words2 = {
          "wxqkj", "whqg", "cckgh", "cdxg", "cdxdt", "cdht", "ktgxt", "ktgch", "ktdw", "ktdc", "jqw", "jmc", "jmg"
        };
        System.out.println(new AlienDictionary().test(words));
    }

    /*
    TEST
     */
    public String test(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap();
        //Initialize arrays
        for(String t: words) {
            for(Character c: t.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        //Configure arrays
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            //We do not have in-degree (edges)
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        //BFS algo
        Queue<Character> q = new LinkedList<>();
        for(Character c: counts.keySet()) {
            if(counts.get(c).equals(0))
                q.add(c);
        }
        var sBuilder = new StringBuilder();
        while(!q.isEmpty()) {
            Character c = q.poll();
            sBuilder.append(c);
            for(Character ch: adjList.get(c)) {
                counts.put(ch, counts.get(ch) - 1);
                if(counts.get(ch).equals(0)) {
                    q.add(ch);
                }
            }
        }
        if(sBuilder.length() < counts.size()) return "";
        return sBuilder.toString();
    }
    /*END TEST*/

    /*
    BFS algo, use in-degree
     */
    public String alienOrder(String[] words) {
        // Step 0: Create data structures and find all unique letters.
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        // Step 2: Breadth-first search.
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
