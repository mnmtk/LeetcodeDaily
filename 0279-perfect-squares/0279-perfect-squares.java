class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); 
        return helper(n, memo);
    }
    private int helper(int num, int[] memo) {
        if (num == 0) return 0;
        if (memo[num] != -1) return memo[num]; 
        int minCount = num; 
        for (int i = 1; i * i <= num; i++) {
            minCount = Math.min(minCount, 1 + helper(num - i * i, memo));
        }
        memo[num] = minCount;
        return minCount;
    }
}