import java.util.Arrays;

class Solution {
    int[] memo;

    public int climbStairs(int n, int[] costs) {
        // Create a memo array initialized to -1 (meaning "uncalculated")
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        // Start from step 0 (ground level) with cost 0
        return solve(0, n, costs);
    }

    private int solve(int currentStep, int targetStep, int[] costs) {
        // Base case: Reached the destination step
        if (currentStep == targetStep) {
            return 0;
        }

        // Return cached result if already calculated
        if (memo[currentStep] != -1) {
            return memo[currentStep];
        }

        int minCost = Integer.MAX_VALUE;

        // Try jumping 1, 2, or 3 steps
        for (int j = 1; j <= 3; j++) {
            int nextStep = currentStep + j;

            if (nextStep <= targetStep) {
                // Cost for this single move = step fee + jump effort (j * j)
                int stepFee = costs[nextStep - 1];
                int jumpEffort = j * j;

                // Recursive call to get best cost from nextStep to target
                int totalForThisPath = stepFee + jumpEffort + solve(nextStep, targetStep, costs);

                minCost = Math.min(minCost, totalForThisPath);
            }
        }

        // Save result in memo table before returning
        return memo[currentStep] = minCost;
    }
}