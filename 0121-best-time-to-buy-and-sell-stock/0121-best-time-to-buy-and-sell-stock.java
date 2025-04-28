class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            ans = Math.max(profit, ans);
            min = Math.min(prices[i], min);
        }

        return ans;
    }
}
