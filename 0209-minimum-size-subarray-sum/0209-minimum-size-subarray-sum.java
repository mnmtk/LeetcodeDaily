class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int ans = Integer.MAX_VALUE;
        int runningSum = 0;

        for (int right = 0; right < nums.length; right++) {
            runningSum += nums[right];

            while (runningSum >= target) {
                ans = Math.min(right - left + 1, ans);
                runningSum -= nums[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans; 
    }
}