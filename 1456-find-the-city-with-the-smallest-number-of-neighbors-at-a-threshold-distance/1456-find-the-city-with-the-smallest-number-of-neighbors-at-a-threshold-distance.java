class Solution {

    public void dijkstra(int n, List<int[]>[] adjList, int[] shortPath, int source) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

        pq.add(new int[] {source, 0});
        Arrays.fill(shortPath, Integer.MAX_VALUE);

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int city = curr[0];
            int dist = curr[1];

             if(dist > shortPath[city]) {
                continue;
            }

            for(int[] neigh : adjList[city]) {
                int ncity = neigh[0];
                int ndist = neigh[1];

                if(shortPath[ncity] > dist + ndist) {
                    shortPath[ncity] = dist + ndist;
                    pq.add(new int[] {ncity, shortPath[ncity]});
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<int[]>[] adjacencyList = new List[n];

        int[][] shortestPathMatrix = new int[n][n];

        for(int i = 0; i < n ; i ++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE);
            shortestPathMatrix[i][i] = 0;
            adjacencyList[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            adjacencyList[start].add(new int[] {end, weight});
            adjacencyList[end].add(new int[] {start, weight});
        }

        for(int i = 0 ; i < n ; i++) {
            dijkstra(n, adjacencyList, shortestPathMatrix[i], i);
        }
        
        return getCity(n, shortestPathMatrix, distanceThreshold); 
    }

    int getCity(int n, int[][] shortestPathMatrix, int k
    ) {
        int fewest = -1;
        int count = Integer.MAX_VALUE;

        
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } 
                if (shortestPathMatrix[i][j] <= k) {
                    reachable++;
                }
            }
        

              if (reachable < count || (reachable == count && fewest < i)) {
                count = reachable;
                fewest = i;
            }
        }
        
        return fewest;
    }
}