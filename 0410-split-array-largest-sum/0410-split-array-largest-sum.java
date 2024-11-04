class Solution {
    public boolean feasible(int cuts, int[] nums, int k) {

        int splits = 1;
        int sum = 0;

        for(int num : nums) {
            sum += num;
            if(sum > cuts) {
                sum = num;
                splits++;
                if(splits > k) {
                    return false;
                }

            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for(int num : nums) {
            right += num;
            left = Math.max(num, left);
        }


        while (left < right) {
            int mid = left + (right-left)/2;
            if(feasible(mid, nums, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
