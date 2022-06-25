package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.Arrays;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDataInLogFiles {

    /*
    The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents.
If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.
     */

    public static void main(String[] args) {
        String[] logs = {
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };
        //"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"
        var obj = new ReorderDataInLogFiles();
        String[] result = obj.reorderLogFiles(logs);
        Arrays.asList(result).forEach(System.out::println);
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else if (!isDigit1 && isDigit2) {
                return -1;
            } else {
                return 0;
            }
        });
        return logs;
    }


}
