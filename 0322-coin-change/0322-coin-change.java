class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;

        if(coins.length == 0) return -1;


        Integer[][] dp = new Integer[coins.length][amount + 1];


        int possible = ks(coins, amount, 0, dp);

        return possible == Integer.MAX_VALUE ? -1 : possible;

    }

    public int ks(int[] coins, int amount, int index, Integer[][] dp) {

        if(amount == 0) {
            return 0;
        }

        if(amount < 0 || coins.length == index) {
            return Integer.MAX_VALUE;
        }

        if(dp[index][amount] != null) {
            return dp[index][amount];
        };

        if(index >= coins.length || amount < 0) return Integer.MAX_VALUE;
        
        int coinsInclude = ks(coins, amount - coins[index], index, dp);

        if(coinsInclude != Integer.MAX_VALUE) {
            coinsInclude++;
        }

        int coinsExclude = ks(coins, amount, index+1, dp);

        return dp[index][amount] = Math.min(coinsInclude, coinsExclude);
    }
}