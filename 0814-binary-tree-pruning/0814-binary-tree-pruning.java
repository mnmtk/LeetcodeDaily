class Solution {
    public TreeNode pruneTree(TreeNode root) {
        // If the entire tree is zeroes and gets pruned, return null
        return shouldKeep(root) ? root : null;
    }

    private boolean shouldKeep(TreeNode node) {
        if (node == null) return false;

        // Recursively check children
        boolean keepLeft = shouldKeep(node.left);
        boolean keepRight = shouldKeep(node.right);

        // This is where you do the direct modification!
        // If a child shouldn't be kept, we snip the connection right here.
        if (!keepLeft) node.left = null;
        if (!keepRight) node.right = null;

        // Keep this current node if it has a valid left child, 
        // a valid right child, or if its own value is 1.
        return keepLeft || keepRight || node.val == 1;
    }
}