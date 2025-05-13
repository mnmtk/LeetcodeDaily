class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = Integer.MIN_VALUE;
        for(int price : prices) {
            profit = Math.max(profit, price - min);
            min = Math.min(price, min);
        }

        return profit;
    }
}