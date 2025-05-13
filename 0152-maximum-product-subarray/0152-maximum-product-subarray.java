class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp = max;
            max = Math.max(num, Math.max(max * num, min * num));
            min = Math.min(num, Math.min(min * num, temp * num));

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }
}
