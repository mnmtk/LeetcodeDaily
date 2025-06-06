class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int[] visited = new int[n];

        //return dfs(source, destination, graph, visited);
        return bfs(source, destination, graph, visited);
    }

    public boolean dfs(int source, int destination, Map<Integer, List<Integer>> graph,
            int[] visited) {

        if (source == destination)
            return true;

        visited[source] = 1;

        for (int nei : graph.get(source)) {
            if (visited[nei] != 1) {
                if (dfs(nei, destination, graph, visited))
                    return true;
            }
        }

        return false;
    }

    public boolean bfs(int source, int destination, Map<Integer, List<Integer>> graph,
            int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == destination)
                return true;

     
            for (int nei : graph.get(curr)) {
                if (visited[nei] != 1) {
                    visited[nei] = 1;
                    queue.offer(nei);
                }
            }
        }

        return false;
    }
}