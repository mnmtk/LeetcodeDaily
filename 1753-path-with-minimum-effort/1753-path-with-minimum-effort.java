class Solution {
    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));


        pq.offer(new int[]{0, 0, 0});

        int[][] currentEfforts = new int[n][m];
        for(int i = 0 ; i < n ; i ++) {
        Arrays.fill(currentEfforts[i], Integer.MAX_VALUE);
        }
        

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            
            int x = current[0];
            int y = current[1];
            int effort = current[2];

            int val = heights[x][y];

            if(x == n-1 && y == m-1) return effort;

            for(int[] dirs : DIRECTIONS) {
                int newX = x + dirs[0]; 
                int newY = y + dirs[1];

                if(newX <0 || newY < 0 || newX >= n || newY >= m) continue;


                int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));
        
                if(newEffort < currentEfforts[newX][newY]) {
                    currentEfforts[newX][newY] = newEffort;
                    pq.offer(new int[] {newX, newY, newEffort});
                }
            }
        }

        return currentEfforts[n - 1][m - 1];
        
    }
}