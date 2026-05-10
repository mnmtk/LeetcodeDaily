class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        // The magic happens here:
        // root.left's new left is the original right sibling
        root.left.left = root.right;
        // root.left's new right is the original parent (root)
        root.left.right = root;

        // Important: Null out original pointers to prevent cycles
        root.left = null;
        root.right = null;

        return newRoot;
    }
}