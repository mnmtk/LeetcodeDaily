class Solution {
    public int maxProfit(int[] prices) {
        int  minimumPriceTillNow = prices[0];
        int max = 0;
        for(int price : prices) {
            minimumPriceTillNow = Math.min(price,minimumPriceTillNow);
            int profit = price - minimumPriceTillNow;
            max = Math.max(profit, max);
        
        }
        return max;
    }
}