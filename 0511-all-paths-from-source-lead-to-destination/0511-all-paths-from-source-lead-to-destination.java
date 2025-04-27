import java.util.*;

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        int[] state = new int[n];
        return dfs(source, destination, graph, state);
    }

    private boolean dfs(int node, int destination, Map<Integer, List<Integer>> graph, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        if (!graph.containsKey(node) || graph.get(node).isEmpty()) {
            return node == destination;
        }

        state[node] = 1;

        for (int nei : graph.get(node)) {
            if (!dfs(nei, destination, graph, state)) {
                return false;
            }
        }

        state[node] = 2; 
        return true;
    }
}
