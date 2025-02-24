import java.util.*;

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countRestrictedPaths(int n, int[][] edges) {
        // Step 1: Create adjacency list
        List<int[]>[] adjList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        // Step 2: Calculate shortest distances to node n
        int[] distToLast = dijkstra(n, adjList, n);

        // Step 3: Count restricted paths using DFS and DP
        Map<Integer, Integer> dp = new HashMap<>();
        return dfs(1, n, adjList, distToLast, dp);
    }

    private int[] dijkstra(int n, List<int[]>[] adjList, int source) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : adjList[node]) {
                int nextNode = neighbor[0], nextDist = neighbor[1];
                if (dist[nextNode] > dist[node] + nextDist) {
                    dist[nextNode] = dist[node] + nextDist;
                    pq.add(new int[] {nextNode, dist[nextNode]});
                }
            }
        }
        return dist;
    }

    private int dfs(int node, int n, List<int[]>[] adjList, int[] distToLast, Map<Integer, Integer> dp) {
        if (node == n) return 1;
        if (dp.containsKey(node)) return dp.get(node);

        int count = 0;

        for (int[] neighbor : adjList[node]) {
            int nextNode = neighbor[0];
            if (distToLast[node] > distToLast[nextNode]) {
                count = (count + dfs(nextNode, n, adjList, distToLast, dp)) % MOD;
            }
        }
        dp.put(node, count);
        return count;
    }
}
