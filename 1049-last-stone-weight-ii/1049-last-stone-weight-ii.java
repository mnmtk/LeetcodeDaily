class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sumStWt = 0;
        for (int stone : stones) {
            sumStWt += stone;
        }
        
        int target = sumStWt / 2;
        // Size target + 1 safely handles indices from 0 up to target
        Integer[][] dp = new Integer[stones.length][target + 1];
        
        int maxSubsetSum = helper(stones, 0, 0, target, dp);

        // Minimum difference = (sumStWt - pile1) - pile1
        return sumStWt - 2 * maxSubsetSum;
    }
    
    //"What is the maximum sum of stones we can pack into Pile 1 without exceeding target (where target = sumStWt / 2)?"

    private int helper(int[] stones, int index, int currentSum, int target, Integer[][] dp) {
        if (index == stones.length) {
            return currentSum;
        }
        
        if (dp[index][currentSum] != null) {
            return dp[index][currentSum];
        }
        
        // Option 1: Exclude stones[index] from subset
        int exclude = helper(stones, index + 1, currentSum, target, dp);
        
        // Option 2: Include stones[index] (if it does not exceed target)
        int include = 0;
        if (currentSum + stones[index] <= target) {
            include = helper(stones, index + 1, currentSum + stones[index], target, dp);
        }
        
        dp[index][currentSum] = Math.max(include, exclude);
        return dp[index][currentSum];
    }
}