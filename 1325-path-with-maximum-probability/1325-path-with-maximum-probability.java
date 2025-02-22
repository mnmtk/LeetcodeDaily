import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int i = 0;
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], i});
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], i});
            i++;
        }

        // PriorityQueue for max-heap (max probability path)
        PriorityQueue<Map.Entry<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Store the probabilities, initializing with 0
        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start_node] = 1.0;

        // Start the search from the start_node
        pq.offer(new AbstractMap.SimpleEntry<>(start_node, 1.0));

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Double> curr = pq.poll();
            int node = curr.getKey();
            double probability = curr.getValue();

            if (node == end_node) {
                return probability;
            }

            // Explore neighbors
            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                double edgeProb = succProb[neighbor[1]];

                double newProb = probability * edgeProb;
                if (newProb > prob[nextNode]) {
                    prob[nextNode] = newProb;
                    pq.offer(new AbstractMap.SimpleEntry<>(nextNode, newProb));
                }
            }
        }

        return 0.0; // Return 0 if no path is found
    }
}