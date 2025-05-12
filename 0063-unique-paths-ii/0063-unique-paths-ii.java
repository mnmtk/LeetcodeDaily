class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        // If start or end is an obstacle, no path exists
        if (obstacleGrid[0][0] == 1 || obstacleGrid[r - 1][c - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[r][c];
        dp[0][0] = 1;  // start point

        // Initialize first column
        for (int i = 1; i < r; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        // Initialize first row
        for (int j = 1; j < c; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }

        // Fill dp table
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[r - 1][c - 1];
    }
}
