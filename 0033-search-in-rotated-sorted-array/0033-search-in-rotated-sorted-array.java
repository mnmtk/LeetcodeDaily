class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Return the index of the target
            }

            // Determine which segment is sorted
            if (nums[left] <= nums[mid]) { // Left segment is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search in the left segment
                } else {
                    left = mid + 1; // Search in the right segment
                }
            } else { // Right segment is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search in the right segment
                } else {
                    right = mid - 1; // Search in the left segment
                }
            }
        }

        return -1; // Target not found
    }
}
