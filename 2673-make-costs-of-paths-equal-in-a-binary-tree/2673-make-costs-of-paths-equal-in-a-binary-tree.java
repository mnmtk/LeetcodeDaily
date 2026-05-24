class Solution {
    public int minIncrements(int n, int[] cost) {
        int totalIncrements = 0;

        // Start from the last internal node (parent of the last leaves) 
        // and move backwards up to the root (index 0).
        for (int i = (n / 2) - 1; i >= 0; i--) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            // 1. Add the difference between siblings to our total increments
            totalIncrements += Math.abs(cost[leftChild] - cost[rightChild]);

            // 2. Pass the maximum path value up to the parent node
            cost[i] += Math.max(cost[leftChild], cost[rightChild]);
        }

        return totalIncrements;
    }
}