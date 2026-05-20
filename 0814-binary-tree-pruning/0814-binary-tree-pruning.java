class Solution {
    public TreeNode pruneTree(TreeNode root) {
        // Base case: if the node is null, nothing to prune
        if (root == null) return null; 

        // 1. Recursively prune left and right subtrees and update pointers
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 2. Decide if the current node itself needs to be pruned.
        // It should be pruned ONLY if it's now a leaf and its value is 0.
        if (root.left == null && root.right == null && root.val == 0) {
            return null; // Prune this node
        }

        // Otherwise, keep this node
        return root;
    }
}