class Solution {
    private Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 0) return -1;

        dp = new Integer[coins.length][amount + 1];
        
        int res = coinChangeFrom(coins, amount, 0);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int coinChangeFrom(int[] coins, int amount, int currentIndex) {
        if(amount == 0) return 0;

        if(amount < 0 || currentIndex == coins.length) return Integer.MAX_VALUE;

        if(dp[currentIndex][amount] != null) return dp[currentIndex][amount];


        int count1= Integer.MAX_VALUE;
        int res = coinChangeFrom(coins, amount - coins[currentIndex], currentIndex);

        if(res != Integer.MAX_VALUE) {
            count1 = res + 1; 
        }

        int coint2 = coinChangeFrom(coins, amount, currentIndex + 1);

        return dp[currentIndex][amount] = Math.min(count1, coint2);

    }
}