class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int window = 2;
        int right = 2;
        while (right <= n) {
            if (right < n && nums[right - 1] - nums[right] == nums[right - 2] - nums[right - 1]) {
                window += 1;
                right += 1;
            } else {
                ans += ((window - 1) * (window - 2)) / 2;
                window = 2;
                right += 1;
            }
        }
        return ans;
    }
}