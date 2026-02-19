class Solution {

    //think like this, if i sell today? how can i get max profit?
    // may be if i sold least before me then -> maintain it,
    // but we expect it to increase? -> so we maintain at each point

    // TC -> O(n)
    // sc -> O(1)
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