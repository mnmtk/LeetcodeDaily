class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correctIdx = nums[i] - 1;
                if (nums[i] != nums[correctIdx]) {
                    int temp = nums[i];
                    nums[i] = nums[correctIdx];
                    nums[correctIdx] = temp;
                } else {
                    return nums[i];
                }
            } else {
				i++;
			}
        }

        return 0;
    }
}

// TC: O(n), SC: O(1)