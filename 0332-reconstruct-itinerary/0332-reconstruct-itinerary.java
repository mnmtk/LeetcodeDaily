import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        // Start DFS from "JFK"
        dfs("JFK");

        return itinerary;
    }

    private void dfs(String airport) {
        PriorityQueue<String> neighbors = graph.get(airport);

        while(neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.poll();
            dfs(next);
        }

        itinerary.addFirst(airport);
    }
}
