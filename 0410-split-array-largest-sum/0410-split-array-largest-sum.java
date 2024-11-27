class Solution {

    public boolean feasible(int max, int[] nums, int k) {

        int split = 1;
        int sum = 0;
        for(int num : nums) {
            sum+=num;
            if(sum > max) {
                sum = num;
                split++;
                if(split > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;

        for (int num : nums) {
            left = Math.max(left, num);
            right+= num;
        }

        while(left < right) {
            int mid = left + (right - left)/2;
            if(feasible(mid, nums, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}