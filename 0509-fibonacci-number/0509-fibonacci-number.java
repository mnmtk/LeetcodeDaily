class Solution {
    int[] dp = java.util.stream.IntStream.generate(() -> -1).limit(1000000).toArray();

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fib(n - 1) + fib(n - 2);
    }
}