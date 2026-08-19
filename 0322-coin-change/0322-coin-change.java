class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE - 1;   // now INF + 1 doesn't wrap

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}