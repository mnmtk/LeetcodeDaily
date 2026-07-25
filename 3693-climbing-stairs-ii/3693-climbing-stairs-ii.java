class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] minCostToReach = new int[n + 1];
        minCostToReach[0] = 0; // Ground level costs nothing

        for (int currentStep = 1; currentStep <= n; currentStep++) {
            int cheapestWay = Integer.MAX_VALUE;
            
            // Try jump sizes of 1, 2, or 3 steps
            for (int jumpSize = 1; jumpSize <= 3; jumpSize++) {

                int previousStep = currentStep - jumpSize;

                if (previousStep >= 0) {
                    int landingFee = costs[currentStep - 1]; // Array is 0-indexed
                    int jumpEffort = jumpSize * jumpSize;
                    
                    int totalCostFromThisJump = minCostToReach[previousStep] + landingFee + jumpEffort;
                    
                    cheapestWay = Math.min(cheapestWay, totalCostFromThisJump);
                }
            }
            
            minCostToReach[currentStep] = cheapestWay;
        }

        return minCostToReach[n];
    }
}