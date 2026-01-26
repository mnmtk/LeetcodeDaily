class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int totalProd = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) zeroCount++;
            else totalProd *= num;
        }

        if (zeroCount > 1) return ans; // All will be 0

        for (int i = 0; i < n; i++) {
            if (zeroCount == 1) {
                // If there's one zero, only the zero's index gets the product
                ans[i] = (nums[i] == 0) ? totalProd : 0;
            } else {
                // Standard case: no zeros
                ans[i] = totalProd / nums[i];
            }
        }
        return ans;
    }
}