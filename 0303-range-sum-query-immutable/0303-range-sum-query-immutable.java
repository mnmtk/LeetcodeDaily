class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = nums[0];
        sums[nums.length - 1] = 0;
        for(int i = 0 ; i < nums.length; i ++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {

        return sums[right +1] - sums[left];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */