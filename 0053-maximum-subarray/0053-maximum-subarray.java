class Solution {
    public int maxSubArray(int[] nums) {
        //at each point i can either include and move or leave previois and move.

        int max = nums[0];
        int sum = 0;
        for(int num : nums) {
            int currMax = Math.max(sum + num, num);
            max = Math.max(currMax, max);
            sum = currMax;
        }

        return max;
    }
}