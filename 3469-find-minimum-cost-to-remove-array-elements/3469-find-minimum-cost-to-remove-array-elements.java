class Solution {
    private int[][] dp;

    private int recur(int prev,int i,int nums[],int n) {

        if(n <= 2){
            return Math.max(nums[0],nums[n-1]);
        }

        if(i >= n) return nums[prev];

        if(i == n-1){
            return Math.max(nums[prev],nums[i]);
        }

        if(dp[prev][i] != 0) return dp[prev][i];

        int a = Math.max(nums[i], nums[i+1]) + recur(prev,i+2,nums,n);
        int b = Math.max(nums[prev], nums[i+1]) + recur(i,i+2,nums,n);
        int c = Math.max(nums[prev], nums[i]) + recur(i+1,i+2,nums,n);
        
        return dp[prev][i] = Math.min(a, Math.min(b,c));

    }

    public int minCost(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        return recur(0,1,nums,n);
    }

}