package tests.topQuestionsTest;

import java.util.Arrays;

public class ReorderDataInLogFilesTest {

    public static void main(String[] args) {
        String[] logs = {
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };
        var obj = new ReorderDataInLogFilesTest();
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
                int comp = split1[1].compareTo(split2[1]);
                if(comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if(isDigit1 && !isDigit2) {
                return 1;
            } else if(!isDigit1 && isDigit2) {
                return -1;
            } else {
                return 0;
            }
        });
        return logs;
    }

}
