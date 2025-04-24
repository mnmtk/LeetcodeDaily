class Solution {
public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

    // Initial edges from i to i+1
    for (int i = 0; i < n - 1; i++) adjList.get(i).add(i + 1);

    int[] inDegree = new int[n];
    for (int i = 0; i < n; i++) {
        for (int v : adjList.get(i)) {
            inDegree[v]++;
        }
    }

    // Compute initial shortest distances using topological order
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    Queue<Integer> zeroIndegree = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (inDegree[i] == 0) zeroIndegree.add(i);
    }

    List<Integer> topoOrder = new ArrayList<>();
    while (!zeroIndegree.isEmpty()) {
        int node = zeroIndegree.poll();
        topoOrder.add(node);
        for (int neighbor : adjList.get(node)) {
            inDegree[neighbor]--;
            if (inDegree[neighbor] == 0) zeroIndegree.add(neighbor);
        }
    }

    if (topoOrder.size() != n) {
        // Initial graph has cycle (should not happen here)
        return new int[queries.length]; // or handle error
    }

    // Relax edges in topological order
    for (int node : topoOrder) {
        if (dist[node] == Integer.MAX_VALUE) continue;
        for (int neighbor : adjList.get(node)) {
            if (dist[node] + 1 < dist[neighbor]) {
                dist[neighbor] = dist[node] + 1;
            }
        }
    }

    int[] result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
        int u = queries[i][0];
        int v = queries[i][1];

        adjList.get(u).add(v);

        inDegree[v]++;

        Queue<Integer> queue = new LinkedList<>();
        if (dist[u] != Integer.MAX_VALUE && dist[u] + 1 < dist[v]) {
            dist[v] = dist[u] + 1;
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // If dist[n-1] is still Integer.MAX_VALUE, no path exists
        result[i] = dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }

    return result;
}

}