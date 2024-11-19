class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = 1;

        for(int num : nums) {
            right = Math.max(right, num);
        }


        while(left < right) {
            int mid = left + (right - left)/2;

            if(possible(mid, nums, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean possible(int yeh, int[] nums, int k) {

        int count = 0;

        // for(int num : nums) {
        //     count += Math.ceil(num/yeh);
        // }
        for (int num : nums) {
            count += (num + yeh - 1) / yeh; // Equivalent to Math.ceil((double) num / yeh)
        }


        return count <= k;
    }
}