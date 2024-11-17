class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left =0;
        int right = nums[n-1]-nums[0];


        while(left < right) {
            int mid = left + (right - left)/2;

            if(enough(mid, k, nums)) {
                right = mid;
            } else{ 
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean enough(int distance, int k, int[] nums) {

        int count = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;

        while(i < n || j < n) {
            while(j<n && nums[j] - nums[i] <= distance) {
                j++;
                count += j-i-1;
            }
            i++;
        }

        return count >= k;
    }
}