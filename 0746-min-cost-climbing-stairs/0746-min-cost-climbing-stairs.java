import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // You can start at index 0 OR index 1
        return Math.min(min_cost(0, cost, dp), min_cost(1, cost, dp)); 
    }

    private int min_cost(int index, int[] cost, int[] dp) {
        // Base case: Reached or surpassed the top floor
        if (index >= cost.length) {
            return 0;
        }

        // Return memoized result if already computed
        if (dp[index] != -1) {
            return dp[index];
        }

        // Cost for current step + min cost of taking 1 or 2 steps forward
        int oneStep = min_cost(index + 1, cost, dp);
        int twoStep = min_cost(index + 2, cost, dp);

        return dp[index] = cost[index] + Math.min(oneStep, twoStep);
    }
}