class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
				i++;
			}
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// TC: O(n), SC: O(1)