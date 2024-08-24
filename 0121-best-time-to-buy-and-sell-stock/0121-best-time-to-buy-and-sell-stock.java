class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int profit = 0;

        for(int i = 1 ; i < prices.length; i++) {
            profit = Math.max(Math.max(prices[i] - min, profit), 0);
            if(prices[i] < min) {
                min = prices[i];
            }
        }

        return profit;
    }
}