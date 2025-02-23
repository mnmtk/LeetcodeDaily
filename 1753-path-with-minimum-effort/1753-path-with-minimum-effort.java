import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // PriorityQueue will store the cell with current effort
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{0, 0, 0}); // {x, y, effort}

        // Initialize efforts with maximum value
        int[][] currentEfforts = new int[n][m];
        for (int[] row : currentEfforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        currentEfforts[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int effort = current[2];

            // If we reach the bottom-right corner
            if (x == n - 1 && y == m - 1) return effort;

            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0]; 
                int newY = y + dir[1];

                // Check bounds
                if (newX < 0 || newY < 0 || newX >= n || newY >= m) continue;

                // Calculate the effort to reach the new cell based on height difference
                int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));

                // If the new effort is less than the previously recorded effort, update and add to queue
                if (newEffort < currentEfforts[newX][newY]) {
                    currentEfforts[newX][newY] = newEffort;
                    pq.offer(new int[] {newX, newY, newEffort});
                }
            }
        }

        // Return effort to reach the bottom-right corner
        return currentEfforts[n - 1][m - 1];
    }
}
