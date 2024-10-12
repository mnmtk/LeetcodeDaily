class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;
        if(coins.length == 0) return -1;

        dp = new Integer[coins.length][amount+1];
        int result = coinChangeKnapSack(coins, 0, amount);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int coinChangeKnapSack(int[] coins, int coin, int target) {

        if(target == 0) {
            return 0;
        }

        if(target < 0 || coin >= coins.length) {
            return Integer.MAX_VALUE;
        }

        if(dp[coin][target] != null) return dp[coin][target];

        int count1 = coinChangeKnapSack(coins, coin, target - coins[coin]);

         if(count1 != Integer.MAX_VALUE) {
            count1++;
        }

        int count2 = coinChangeKnapSack(coins, coin + 1, target);

        return dp[coin][target] = Math.min(count1, count2);
    }

}