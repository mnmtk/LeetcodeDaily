class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] seen = new boolean[n];
        return bfs(graph, seen, source, destination);
    }

    private boolean bfs(List<List<Integer>> graph, boolean[] seen, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();

        seen[source] = true;              // mark on PUSH
        queue.offer(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == destination) return true;

            for (int nei : graph.get(curr)) {
                if (!seen[nei]) {         // check the NEIGHBOR
                    seen[nei] = true;     // mark on PUSH
                    queue.offer(nei);
                }
            }
        }
        return false;
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] seen, int curr, int destination) {
        if (curr == destination) return true;

        seen[curr] = true;

        for (int nei : graph.get(curr)) {
            if (!seen[nei] ) {
                return dfs(graph, seen, nei, destination);
            }
        }
        return false;                     // exhausted all branches
    }
}