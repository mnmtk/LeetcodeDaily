class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int[] maxProfitLeft = new int[prices.length];
        int minPrice = prices[0];

        for(int i=1; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfitLeft[i] = Math.max(prices[i] - minPrice, maxProfitLeft[i-1]);
        }


        int[] maxPricesRight = new int [prices.length];
        int max = 0;
        int maxPrice = prices[prices.length - 1];

        for(int i = prices.length - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxPricesRight[i] = maxPrice - prices[i];

            max = Math.max(maxPricesRight[i] + maxProfitLeft[i], max);
        }

        return max;
        
    }
}