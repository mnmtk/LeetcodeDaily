class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        
        // Calculate the maximum height to the left of each bar
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate the maximum height to the right of each bar
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        int water = 0;
        // Calculate the amount of water trapped
        for (int i = 0; i < size; i++) {
            water += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        
        return water;
    }
}
