class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        int last = nums.length - 1;

        for(int i =0 ;i <=furthest && furthest < last; ++i) {
            furthest = Math.max(furthest, i + nums[i]);
        }

        return furthest >= last;

        
    }
}