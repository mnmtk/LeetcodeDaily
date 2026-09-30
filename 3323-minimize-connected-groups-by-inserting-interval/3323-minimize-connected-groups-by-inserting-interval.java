import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int minConnectedGroups(int[][] intervals, int k) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Merge overlapping or touching intervals into disjoint groups
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(new int[]{interval[0], interval[1]});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        int m = merged.size();
        int maxSaved = 0;
        
        // Step 3: Use Two Pointers / Sliding Window to find max (j - i) such that s_j - e_i <= k
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j + 1 < m && (long) merged.get(j + 1)[0] - merged.get(i)[1] <= k) {
                j++;
            }
            maxSaved = Math.max(maxSaved, j - i);
        }
        
        // Minimum connected groups remaining
        return m - maxSaved;
    }
}