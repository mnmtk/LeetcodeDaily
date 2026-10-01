import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build graph: directed edge from b -> a (poorer -> richer)
        for (int[] pair : richer) {
            int a = pair[0];
            int b = pair[1];
            graph.get(b).add(a);
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        // Compute quietest richer person for each individual
        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, answer);
        }
        
        return answer;
    }
    
    private int dfs(int node, List<List<Integer>> graph, int[] quiet, int[] answer) {
        if (answer[node] != -1) {
            return answer[node];
        }
        
        // Base candidate is the person themselves
        int minQuietPerson = node;
        
        for (int richerPerson : graph.get(node)) {
            int candidate = dfs(richerPerson, graph, quiet, answer);
            if (quiet[candidate] < quiet[minQuietPerson]) {
                minQuietPerson = candidate;
            }
        }
        
        answer[node] = minQuietPerson;
        return answer[node];
    }
}