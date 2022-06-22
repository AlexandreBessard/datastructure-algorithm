package leetcode.datastructure.graph.depthFirstSearch.exercices;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<>(List.of("MUC","LHR"));
        List<String> ticket2 = new ArrayList<>(List.of("JFK","MUC"));
        List<String> ticket3 = new ArrayList<>(List.of("SFO","SJC"));
        List<String> ticket4 = new ArrayList<>(List.of("LHR","SFO"));

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        //Example from correction:
        List<List<String>> ticketsv2 = new ArrayList<>();
        List<String> ticket1_ = new ArrayList<>(List.of("BBB","CCC"));
        List<String> ticket2_ = new ArrayList<>(List.of("CCC","JFK"));
        List<String> ticket3_ = new ArrayList<>(List.of("JFK","AAA"));
        List<String> ticket4_ = new ArrayList<>(List.of("JFK","BBB"));

        ticketsv2.add(ticket1_);
        ticketsv2.add(ticket2_);
        ticketsv2.add(ticket3_);
        ticketsv2.add(ticket4_);

        new ReconstructItinerary().findItinerary(ticketsv2);
    }

    Map<String, List<String>> flightMap = new HashMap<>();
    Map<String, boolean[]> visitBitmap = new HashMap<>();
    int flights = 0;
    List<String> result = null;

    /*
    O(E d) where E is the number of total of flights and d is the maximum number of flights from an airport
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        //1) Build the graph
        for(List<String> ticket: tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            List<String> destList;
            if(this.flightMap.containsKey(origin)) {
                destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                destList = new LinkedList<>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }
        //2) Order the destination and init the visit bitmap
        for(Map.Entry<String, List<String>> entry: this.flightMap.entrySet()) {
            Collections.sort(entry.getValue());
            this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        this.flights = tickets.size();
        LinkedList<String> route = new LinkedList<>();
        route.add("JFK");
        //Step 3 backtracking
        this.backtracking("JFK", route);
        return this.result;
    }

    private boolean backtracking(String origin, LinkedList<String> route) {
        if(route.size() == this.flights + 1) {
            this.result = (List<String>) route.clone();
            return true;
        }
        if(!this.flightMap.containsKey(origin)) {
            return false;
        }
        int i = 0;
        boolean[] bitmap = this.visitBitmap.get(origin);
        for(String dest: this.flightMap.get(origin)) {
            if(!bitmap[i]) {
                bitmap[i] = true;
                route.add(dest);
                boolean ret = this.backtracking(dest, route);
                route.pollLast();
                bitmap[i] = false;

                if(ret) return true;
            }
            i++;
        }
        return false;
    }
}
