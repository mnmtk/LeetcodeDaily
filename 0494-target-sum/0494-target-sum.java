class Solution {

    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        return calculateWays(nums, 0, target);
    }

    private int calculateWays(
            int[] nums,
            int index,
            int sum) {

        if (index == nums.length) {
            return sum == 0 ? 1 : 0;
        }

        //sub

        int subWays = calculateWays(nums, index + 1, sum - nums[index]);

        //add

        int addWays = calculateWays(nums, index + 1, sum + nums[index]);

        return subWays + addWays;
    }
}