class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1;
        for(int num : nums) {
            right = Math.max(num, right);
        }

        while(left < right) {
            int mid = left + (right - left)/2;
            if(possible(threshold, nums, mid)) {
                right = mid;
            } else{ 
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean possible(int yeh, int[] nums, int mid) {
        int count = 0;

        for(int num : nums) {
            count += (num + mid - 1)/mid;
        }

        return count <= yeh;
    }
}