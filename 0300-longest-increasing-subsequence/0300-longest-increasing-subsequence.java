class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 0 ;i< nums.length; i++) {
            int max =0;
            for(int j = 0; j<i; j++) {
                if(nums[j]<nums[i]) {
                    max = Math.max(dp[j], max);  // find the max. ss before me ?
                }
            }
             dp[i] = max + 1; // i also needs to be added.
             ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}