class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[0], k-> new ArrayList<>()).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0 ; i < numCourses; i++) {
            if(visited[i] == 0 && !dfs(graph, visited, i)) return false;
        }

        return true;
    }

    boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int course) {
        if(visited[course] == -1) return false;

        if(visited[course] == 1) return true;

        visited[course] = -1;

        //dfs
        for(int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if(!dfs(graph, visited, neighbor)) return false;
        }

        visited[course] = 1;
        return true;
    }
}