import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);  // Crucial: Initialize with sum 0 occurring once
        int sum = 0;
        int ans = 0;
        
        for (int num : nums) {
            sum += num;
            
            // Check if (current sum - k) exists as a previous prefix sum
            if (prefixSum.containsKey(sum - k)) {
                ans += prefixSum.get(sum - k);
            }
            
            // Update frequency of current prefix sum
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
