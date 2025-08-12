class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int[] preq : prerequisites) {
            adjList.computeIfAbsent(preq[1], k -> new ArrayList<>()).add(preq[0]);
            indegrees[preq[0]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
             q.add(i);
            }
        }

        int course = 0;

        int[] lies = new int[numCourses];


        while(!q.isEmpty()) {
            course++;
            int poll = q.poll();
            lies[course - 1] = poll;
            for(Integer nei : adjList.getOrDefault(poll, new ArrayList<>())) {
                indegrees[nei]--;
                if(indegrees[nei] == 0) q.add(nei);
            }
        }

        if(course == numCourses){

        return lies;
        }

        return new int[0];
    }
}