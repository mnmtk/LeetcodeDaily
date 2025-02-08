class Solution {
    public int maximumDetonation(int[][] bombs) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0;i < bombs.length; i++) { //O(Nsquare)
            for(int j = 0; j < bombs.length; j++) {
                int x1 = bombs[i][0];
                int x2 = bombs[j][0];

                int y1 = bombs[i][1];
                int y2 = bombs[j][1];

                int r = bombs[i][2];
                
             


                if((long)r*r >= (long)(x1 - x2) * (x1 - x2) + (long)(y1 - y2) * (y1 - y2)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }

            }
        }

        int answer = 0;

        for(int i =0; i< bombs.length; i++) {
            int count = dfs(i, graph, new HashSet<>());
            answer = Math.max(count, answer);
        }

        return answer;
    }

    public int dfs(int curr, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        int count = 1;
        visited.add(curr);

        for(int neigh : graph.getOrDefault(curr, new ArrayList<>())) {
            if(!visited.contains(neigh)) {
                count+=dfs(neigh, graph, visited);
            }
        }


        return count;
    }
}