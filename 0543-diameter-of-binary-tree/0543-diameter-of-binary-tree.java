class Solution {
    // Keep track of the maximum diameter found across all nodes
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0; // The height of a null node is 0
        }

        // Recursively find the height of the left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // The diameter AT THIS NODE is the sum of the left and right heights
        // Update the global maxDiameter if this one is bigger
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the tree rooted at this node to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}