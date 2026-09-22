class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2); // Max possible taps needed is n + 1
        dp[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            int tapStart = Math.max(0, i - ranges[i]);
            int tapEnd = Math.min(n, i + ranges[i]);
            
            // Update coverage for all positions tap i can reach
            for (int j = tapStart; j <= tapEnd; j++) {
                dp[j] = Math.min(dp[j], dp[tapStart] + 1);
            }
        }
        
        return dp[n] > n + 1 ? -1 : dp[n];
    }
}