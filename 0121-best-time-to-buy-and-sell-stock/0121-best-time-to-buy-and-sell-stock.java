class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lastMin = prices[0];
       for(int price : prices) {
        maxProfit = Math.max(maxProfit, price - lastMin);
        lastMin = Math.min(lastMin, price);
       } 

       return maxProfit;
    }
}