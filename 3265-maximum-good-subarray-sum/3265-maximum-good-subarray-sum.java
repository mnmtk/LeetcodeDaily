class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        long maxValue = Long.MIN_VALUE;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }     
        
        Map<Long, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            
            long searchVal1 = nums[i] - k;
            long searchVal2 = nums[i] + k;
            long maxSum1 = Long.MIN_VALUE, maxSum2 = Long.MIN_VALUE;
            
            if(map.containsKey(searchVal1)) {
                maxSum1 = getMaxVal(prefixSum, map.get(searchVal1), i);
            }
            if(map.containsKey(searchVal2)) {
                maxSum2 = getMaxVal(prefixSum, map.get(searchVal2), i);
            }
        
            maxValue = Math.max(maxValue, Math.max(maxSum1, maxSum2));
            long key = nums[i];
            
            if(map.containsKey(key)) {
                if(prefixSum[i] < prefixSum[map.get(key)]) {
                    map.put(key, i);
                }
            }
            else {
                map.put(key, i);
            }
            
        }
        
        return maxValue == Long.MIN_VALUE ? 0 : maxValue;
    }
    
    private long getMaxVal(long[] prefixSum, int prevIndex, int curIndex) {
        
        long prevSum = prevIndex > 0 ? prefixSum[prevIndex - 1] : 0;
        
        return prefixSum[curIndex] - prevSum;
        
    }
    
}