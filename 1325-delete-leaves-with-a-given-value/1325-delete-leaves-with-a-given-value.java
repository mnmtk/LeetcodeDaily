class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        // 1. Recursively update the left and right subtrees first
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // 2. After updating children, check if the current node is now a target leaf
        if (root.val == target && root.left == null && root.right == null) {
            return null; // Delete this node by returning null to its parent
        }

        // 3. Return the original (potentially modified) root
        return root;
    }
}