package tests.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(0);
        l1.add(3);
        l2.add(1);
        l2.add(2);
        map.put(0, l1);
        map.put(1, l2);
        for(List<Integer> l : map.values()) {
            System.out.print(l);
        }
    }

}
