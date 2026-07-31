class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        
        // Base case: max subarray ending at index 0 is just nums[0]
        dp[0] = nums[0];
        int maxSoFar = dp[0];

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSoFar = Math.max(maxSoFar, dp[i]);
        }

        return maxSoFar;
    }
}