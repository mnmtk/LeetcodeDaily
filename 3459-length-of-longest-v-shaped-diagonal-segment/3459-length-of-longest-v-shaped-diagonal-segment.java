import java.util.Arrays;

class Solution {
    private int m, n;
    // Clockwise order: Up-Right (0), Down-Right (1), Down-Left (2), Up-Left (3)
    private int[][] dirs = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}}; 
    private int[][][][] memo;

    public int lenOfLongestVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n][4][2];

        int ans = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, dfs(grid, r, c, d, 0, 1));
                    }
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int r, int c, int dIdx, int turned, int expected) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != expected) {
            return 0;
        }

        if (memo[r][c][dIdx][turned] != 0) {
            return memo[r][c][dIdx][turned];
        }

        int nextVal = (expected == 1) ? 2 : (expected == 2) ? 0 : 2;

        // Option 1: Keep straight
        int res = 1 + dfs(grid, r + dirs[dIdx][0], c + dirs[dIdx][1], dIdx, turned, nextVal);

        // Option 2: Turn 90 degrees clockwise once
        if (turned == 0) {
            int cwDir = (dIdx + 1) % 4;
            res = Math.max(res, 1 + dfs(grid, r + dirs[cwDir][0], c + dirs[cwDir][1], cwDir, 1, nextVal));
        }

        memo[r][c][dIdx][turned] = res;
        return res;
    }
}