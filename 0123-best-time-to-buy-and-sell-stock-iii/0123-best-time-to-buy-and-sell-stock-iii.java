class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
        if (prices.length == 0 || k == 0)
            return 0;
        int n = prices.length;

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price); // choose to buy
                sell[j] = Math.max(sell[j], buy[j] + price); // choose to sell
            }
        }

        return sell[k];
    }

}