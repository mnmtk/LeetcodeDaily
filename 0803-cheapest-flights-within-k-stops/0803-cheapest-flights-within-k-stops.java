class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights) {
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Format: [cost, current node, number of stops]
        pq.offer(new int[] { 0, src, 0 });
        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];

            if (steps > k + 1) continue;

            if (node == dst) {
                return dist;
            }

            if (steps > stops[node]) continue;

            stops[node] = steps;

            if (!adj.containsKey(node)) continue;
            for (int[] a : adj.get(node)) {
                pq.offer(new int[] { dist + a[1], a[0], steps + 1 });
            }
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}