import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        // Step 1: Initialize data structures
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        // Initialize graph and indegree for all unique chars
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build the graph by comparing adjacent words
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            
            // Check prefix condition invalid case
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            int length = Math.min(word1.length(), word2.length());
            for (int j = 0; j < length; j++) {

                char parent = word1.charAt(j);
                char child = word2.charAt(j);

                if (parent != child) {
                    List<Character> children = graph.get(parent);
                    if (!children.contains(child)) {
                        children.add(child);
                        indegree.put(child, indegree.get(child) + 1);
                    }
                    break; 
                }
            }
        }
        
        // Step 3: Topological sort using BFS (Kahn's algorithm)
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);
            
            for (char neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If result length != number of unique chars, a cycle exists
        if (result.length() != indegree.size()) {
            return "";
        }
        
        return result.toString();
    }
}