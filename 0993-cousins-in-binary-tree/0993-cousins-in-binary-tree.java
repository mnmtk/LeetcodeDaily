class Solution {
    // Arrays to store parent and depth for each node value
    private int[] parent = new int[101];
    private int[] depth = new int[101];

    public boolean isCousins(TreeNode root, int x, int y) {
        // Base case: if root is null, they can't be cousins
        if (root == null) return false;

        // Precompute depths and parents starting from the root (depth 0, parent 0 or -1)
        precompute(root, null, 0);

        // Check the two conditions for cousins
        boolean sameDepth = depth[x] == depth[y];
        boolean differentParent = parent[x] != parent[y];

        return sameDepth && differentParent;
    }

    private void precompute(TreeNode node, TreeNode parentNode, int currentDepth) {
        if (node == null) return;

        // Store the depth of the current node
        depth[node.val] = currentDepth;
        
        // Store the parent's value (use 0 or -1 for the root node)
        parent[node.val] = (parentNode != null) ? parentNode.val : 0;

        // Recursively traverse left and right subtrees
        precompute(node.left, node, currentDepth + 1);
        precompute(node.right, node, currentDepth + 1);
    }
}