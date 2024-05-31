class Solution {
    public int maxProfit(int[] prices) {
        List<List<Integer>> ans = new ArrayList<>();
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
                ans.add(Arrays.asList(i-1, i));
            }
        }    

        System.out.print(ans);    
        return profit;
    }
}