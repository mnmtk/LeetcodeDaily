class Solution {
    private Integer[][] memo;

    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int s : stones) total += s;
        int cap = total / 2;

        memo = new Integer[stones.length][cap + 1];
        int best = maxSubsetSum(stones, 0, cap);
        return total - 2 * best;
    }

    // largest subset sum reachable from stones[i..] that stays within 'remaining'
    private int maxSubsetSum(int[] stones, int i, int remaining) {

        if (i == stones.length) return 0;

        if (memo[i][remaining] != null) return memo[i][remaining];

        int skip = maxSubsetSum(stones, i + 1, remaining);
        int take = 0;
        
        if (stones[i] <= remaining) {
            take = stones[i] + maxSubsetSum(stones, i + 1, remaining - stones[i]);
        }
        return memo[i][remaining] = Math.max(skip, take);
    }
}