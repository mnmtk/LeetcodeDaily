class Solution {
   public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[0] = true;  // Start from room 0
    queue.offer(0);
    
    while (!queue.isEmpty()) {
        int room = queue.poll();
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                visited[key] = true;
                queue.offer(key);
            }
        }
    }
    
    // Check if all rooms are visited
    for (boolean v : visited) {
        if (!v) return false;
    }
    return true;
}

}