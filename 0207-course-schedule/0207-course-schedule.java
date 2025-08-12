class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int[] preq : prerequisites) {
            adjList.computeIfAbsent(preq[0], k -> new ArrayList<>()).add(preq[1]);
            indegrees[preq[1]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
             q.add(i);
            }
        }

        int course = 0;

        while(!q.isEmpty()) {
            course++;
            int poll = q.poll();
            for(Integer nei : adjList.getOrDefault(poll, new ArrayList<>())) {
                indegrees[nei]--;
                if(indegrees[nei] == 0) q.add(nei);
            }
        }

        return course == numCourses;
    }
}