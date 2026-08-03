import java.util.Arrays;

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If target is impossible to reach with total available sum
        if (Math.abs(target) > totalSum) {
            return 0;
        }

        // DP table bounds: range of sum is [-totalSum, +totalSum]
        // Size needed: 2 * totalSum + 1
        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return calculateWays(nums, 0, target, memo, totalSum);
    }

    private int calculateWays(
            int[] nums,
            int index,
            int sum, 
            int[][] memo,
            int offset) {

        // Base case: processed all numbers
        if (index == nums.length) {
            return sum == 0 ? 1 : 0;
        }

        // Prune paths that overshoot the maximum achievable remaining sum
        if (Math.abs(sum) > offset) {
            return 0;
        }

        // Shift sum by offset so negative values become valid positive indices
        int mappedSum = sum + offset;

        // Memoization lookup check
        if (memo[index][mappedSum] != -1) {
            return memo[index][mappedSum];
        }

        // Subtract branch
        int subWays = calculateWays(nums, index + 1, sum - nums[index], memo, offset);

        // Add branch
        int addWays = calculateWays(nums, index + 1, sum + nums[index], memo, offset);

        return memo[index][mappedSum] = subWays + addWays;
    }
}