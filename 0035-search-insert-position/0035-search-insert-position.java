class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length ;

        // Also notice that the input target might be larger 
        // than all elements in nums and thus needs to placed 
        // at the end of the array.


        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] >= target) {
                right = mid; 
            } else {
                left = mid+1;
            }
        }

        return left;
    
    
    }
}