class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int pref = 0;

        for(int i = 0; i < nums.length; i++) {
            if(pref == sum - pref - nums[i]) return i;
            pref += nums[i];
        }

        return -1;
    }
}