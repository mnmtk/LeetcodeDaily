class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        // Named constants for grid checks
        final int OBSTACLE = 1;

        if (obstacleGrid[0][0] == OBSTACLE || obstacleGrid[r - 1][c - 1] == OBSTACLE) {
            return 0;
        }

        int[][] dp = new int[r][c];
        dp[0][0] = 1;

        // Initialize first column
        for (int i = 1; i < r; i++) {
            boolean isOpen = (obstacleGrid[i][0] != OBSTACLE);
            dp[i][0] = (isOpen && dp[i - 1][0] == 1) ? 1 : 0;
        }

        // Initialize first row
        for (int j = 1; j < c; j++) {
            boolean isOpen = (obstacleGrid[0][j] != OBSTACLE);
            dp[0][j] = (isOpen && dp[0][j - 1] == 1) ? 1 : 0;
        }

        // Fill dp table
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] != OBSTACLE) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0; // Explicitly 0 ways if blocked
                }
            }
        }

        return dp[r - 1][c - 1];
    }
}