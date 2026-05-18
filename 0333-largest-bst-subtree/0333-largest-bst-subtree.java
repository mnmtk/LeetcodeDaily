class NodeValue {
    int min, max, size;
    
    NodeValue(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

class Solution {
    private int maxBSTSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxBSTSize;
    }

    private NodeValue helper(TreeNode root) {
        // Base case: An empty tree is a valid BST of size 0
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // If either left or right subtree is NOT a valid BST, this tree can't be a BST
        if (left == null || right == null) return null;

        // Check if the current node satisfies the BST condition
        if (root.val > left.max && root.val < right.min) {
            // Calculate actual min/max for this valid BST
            int currentMin = (root.left != null) ? left.min : root.val;
            int currentMax = (root.right != null) ? right.max : root.val;
            int currentSize = left.size + right.size + 1;

            // Track the global maximum size found so far
            maxBSTSize = Math.max(maxBSTSize, currentSize);

            return new NodeValue(currentMin, currentMax, currentSize);
        }

        // If it fails the BST condition, return null to signal parents
        return null;
    }
}