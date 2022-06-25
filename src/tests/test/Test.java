package tests.test;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        System.out.println("SQRT:" + Math.sqrt(12));

        long max = Integer.MAX_VALUE;
        long val = 100;
        long max2 = Integer.MAX_VALUE;

        System.out.println(max2);
        System.out.println(max2 + val);

        if( (val + max2) < max ) {
            System.out.println("if");
        }

        Map<Integer, Integer> cache =
                new HashMap<>(Map.of(0, 0, 1, 1));
        System.out.println(cache);
    }
}
