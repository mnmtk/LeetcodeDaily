class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[] firstBuySell = new int[n];

        
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            firstBuySell[i] = Math.max(firstBuySell[i - 1], prices[i] - minPrice);
        }

       
        int maxPrice = prices[n - 1];
        int maxTotalProfit = firstBuySell[n - 1]; 
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxTotalProfit = Math.max(maxTotalProfit, maxPrice - prices[i] + firstBuySell[i]);
        }

        return maxTotalProfit;
    }
}