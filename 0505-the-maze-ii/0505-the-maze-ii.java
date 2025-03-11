

public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        // Perform Dijkstra with early exit
        return dijkstra(maze, start, dest, distance);
    }

    public int dijkstra(int[][] maze, int[] start, int[] dest, int[][] distance) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{start[0], start[1], 0});
        
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            
            // Early exit if we reach the destination
            if (s[0] == dest[0] && s[1] == dest[1]) {
                return s[2];  // Return the shortest distance to the destination
            }
            
            // If the current distance is greater than the recorded distance, skip it
            if (distance[s[0]][s[1]] < s[2]) continue;
            
            // Explore the four possible directions
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                
                // Roll in the current direction until hitting a wall
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                
                // Backtrack to the last valid position
                x -= dir[0];
                y -= dir[1];
                
                // Update the distance if we found a shorter path to (x, y)
                if (distance[s[0]][s[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[s[0]][s[1]] + count;
                    queue.offer(new int[]{x, y, distance[x][y]});
                }
            }
        }
        
        // If we exit the loop and didn't reach the destination, return -1
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
