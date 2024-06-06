class Solution {
    public int findMin(int[] nums) {
        return findMinByBinary(nums, 0, nums.length - 1);
    }

    public int findMinByBinary(int[] nums, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
        }
        return nums[low];
    }
}
