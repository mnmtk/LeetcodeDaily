class Solution {
    public int search(int[] nums, int target) {

        int left =0;
        int right = nums.length - 1;

        while(left <= right) {
 int mid = (right + left)/2;
            if(nums[mid] == target) {
                return mid;
            }

           
            if(nums[left] <= nums[mid]) { // left sort
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid; //ethe lbhio
                } else {
                    left = mid + 1; //nooooooooooo
                }

            } else { //ruight sorted

            if(target > nums[mid] && target <= nums[right]) {

                left = mid +1; //etho ?
            } else {
                right = mid; //naaa
            }

            
        }
        }
        return -1;
    }


    
}