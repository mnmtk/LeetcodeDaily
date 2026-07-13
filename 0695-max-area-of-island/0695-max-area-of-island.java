class Solution {
    // 1. Fixed array declaration to 2D
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
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