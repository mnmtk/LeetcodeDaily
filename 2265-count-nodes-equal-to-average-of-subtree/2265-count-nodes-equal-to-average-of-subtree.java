class Solution {
    int ans = 0;

    // Helper class to store the sum and total node count of a subtree
    class SubtreeInfo {
        int sum;
        int count;

        SubtreeInfo(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        calculateSubtree(root);
        return ans;
    }

    private SubtreeInfo calculateSubtree(TreeNode node) {
        // Base case: an empty node contributes 0 to sum and 0 to count
        if (node == null) {
            return new SubtreeInfo(0, 0);
        }

        // Post-order traversal: Get data from left and right subtrees first
        SubtreeInfo left = calculateSubtree(node.left);
        SubtreeInfo right = calculateSubtree(node.right);

        // Calculate totals for the CURRENT subtree
        int currentSum = left.sum + right.sum + node.val;
        int currentCount = left.count + right.count + 1;

        // Check if the current node matches the problem's condition
        // Java integer division automatically handles rounding down (truncation)
        if (node.val == (currentSum / currentCount)) {
            ans++;
        }

        // Return the accumulated data to the parent node
        return new SubtreeInfo(currentSum, currentCount);
    }
}