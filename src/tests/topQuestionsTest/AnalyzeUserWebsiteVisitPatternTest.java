package tests.topQuestionsTest;

import java.util.*;

public class AnalyzeUserWebsiteVisitPatternTest {

    public static void main(String[] args) {
        var obj = new AnalyzeUserWebsiteVisitPatternTest();
        String[] username =
                {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp =
                {1,2,3,4,5,6,7,8,9,10};
        String[] website =
                {"home","about","career","home","cart","maps","home","home","about","career"};
        //Output 2 because home, about and career has been visited by joe and mary
        obj.mostVisitedPattern(username, timestamp, website)
                .forEach(System.out::println);
    }

    public List<String> mostVisitedPattern(String[] username,
                                           int[] timestamp,
                                           String[] website)
    {
        List<Tuple> listTuple = new ArrayList<>();
        for(int i = 0; i < username.length; i++) {
            listTuple.add(new Tuple(username[i], website[i], timestamp[i]));
        }
        Collections.sort(listTuple, (a, b) -> a.timestamp - b.timestamp);
        Map<String, List<String>> userToVisitedWebsite = new HashMap<>();
        for(Tuple t : listTuple) {
            userToVisitedWebsite.putIfAbsent(t.username, new ArrayList<>());
            userToVisitedWebsite.get(t.username).add(t.website);
        }
        Map<String, Integer> seqCount = new HashMap<>();
        int max = 0;
        String sequenceKept = "";
        for(Map.Entry<String, List<String>> entry : userToVisitedWebsite.entrySet()) {
            Set<String> seq = getSequences(entry.getValue());
            for(String s : seq) {
                seqCount.put(s, seqCount.getOrDefault(s, 0) + 1);
                if(seqCount.get(s) > max){
                    max = seqCount.get(s);
                    sequenceKept = s;
                } else if(seqCount.get(s) == max && s.compareTo(sequenceKept) < 0) {
                    sequenceKept = s;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(sequenceKept.split(",")));
    }

    private Set<String> getSequences(List<String> list) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < list.size() - 2; i++) {
            for(int j = i + 1; j < list.size() - 1; j++) {
                for(int k = j + 1; k < list.size(); k++) {
                    set.add(list.get(i)+ "," + list.get(j)+ "," + list.get(k));
                }
            }
        }
        return set;
    }

    static class Tuple {
        String username, website;
        int timestamp;
        public Tuple(String username, String website, int timestamp) {
            this.username = username;
            this.website = website;
            this.timestamp = timestamp;
        }
    }





}
