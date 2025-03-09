class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        for(int i = 1; i < m; i++) {
            for(int j =1; j < n; j++) {
                int left = dp[i-1][j];
                int up = dp[i][j-1];
                dp[i][j] = left + up;
            }
        }

        return dp[m -1 ][n - 1];
    }
}