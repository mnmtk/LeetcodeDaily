class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, i = 0;
        
        while (i < n) {
            int correctIdx = nums[i];
            if (nums[i] < n && nums[i] != nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            } else {
				i++;
			}
        }

        for (int j = 0; j < n; j++) {
            if (j != nums[j]) {
                return j;
            }
        }

        return n;
    }
}

// TC: O(n), SC: O(1)