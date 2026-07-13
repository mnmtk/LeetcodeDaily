class Solution {
    // 1. Fixed array declaration to 2D
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int i, int j) {
    Deque<int[]> q = new ArrayDeque<>();
    grid[i][j] = 0;
    q.offer(new int[]{i, j});

    int area = 0;

    while (!q.isEmpty()) {
        int[] cell = q.poll();
        area++;                            // count on POP
        int r = cell[0], c = cell[1];

        for (int[] d : dir) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;
            if (grid[nr][nc] != 1) continue;

            grid[nr][nc] = 0;              // sink on PUSH
            q.offer(new int[]{nr, nc});
        }
    }
    return area;
}

    private int dfs(int[][] grid, int i, int j) {
    
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

       
        if (grid[i][j] != 1) return 0;

      
        grid[i][j] = 0;
        
        int area = 1; // Count current cell

      
        for (int[] d : dir) {
            area += dfs(grid, i + d[0], j + d[1]);
        }
        
        return area;
    }
}