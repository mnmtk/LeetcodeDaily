import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the original heights array
        int[] expected = Arrays.copyOf(heights, heights.length);
        
        // Sort the expected array
        Arrays.sort(expected);
        
        // Count the number of indices where the heights differ
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
}
