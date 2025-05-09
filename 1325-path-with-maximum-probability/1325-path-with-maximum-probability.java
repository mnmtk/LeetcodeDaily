class Solution {

    public double maxProbability(
            int n,
            int[][] edges,
            double[] succProb,
            int start,
            int end) {

        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
        }

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, -1d);
        maxProb[start] = 1d;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(
                (a, b) -> -Double.compare(a.getKey(), b.getKey()));
                
        pq.add(new Pair<>(1.0, start));
        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double curProb = cur.getKey();
            int curNode = cur.getValue();

            if (curNode == end) {
                return curProb;
            }

            if (maxProb[curNode] != -1)
                continue;

            maxProb[curNode] = curProb;

            if (graph.containsKey(curNode)) { // Check if the node has been processed
                for (Pair<Integer, Double> nxt : graph.getOrDefault(
                    curNode,
                    new ArrayList<>())) {
                        
                    int nxtNode = nxt.getKey();
                    double pathProb = nxt.getValue();

                    pq.add(new Pair<>(curProb * pathProb, nxtNode));

                }
            }
        }

        return 0d;
    }
}