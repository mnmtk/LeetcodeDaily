class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        // dp[i][t] = max distance reachable using a subset of first i stations with t stops
        long[][] dp = new long[N + 1][N + 1];
        
        // Base case: 0 stations, 0 stops -> startFuel
        dp[0][0] = startFuel;

        for (int i = 1; i <= N; ++i) {
            int pos = stations[i - 1][0];
            int fuel = stations[i - 1][1];

            for (int t = 0; t <= i; ++t) {
                // Option 1: Do not stop at station i
                dp[i][t] = dp[i - 1][t];

                // Option 2: Refuel at station i (if reachable with t - 1 stops)
                if (t > 0 && dp[i - 1][t - 1] >= pos) {
                    dp[i][t] = Math.max(dp[i][t], dp[i - 1][t - 1] + fuel);
                }
            }
        }

        // Find the minimum stops needed to reach target
        for (int t = 0; t <= N; ++t) {
            if (dp[N][t] >= target) return t;
        }

        return -1;
    }
}