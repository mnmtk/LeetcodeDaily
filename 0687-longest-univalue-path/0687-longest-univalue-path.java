class Solution {
    int maxEdges = 0;

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 1. Get the max edge-path length from the children
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);

        int leftEdges = 0;
        int rightEdges = 0;

        // 2. If a child matches the current root, it extends the edge path by 1
        if (root.left != null && root.left.val == root.val) {
            leftEdges = leftPath + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightEdges = rightPath + 1;
        }

        // 3. Combine the left and right matching edges through this root
        maxEdges = Math.max(maxEdges, leftEdges + rightEdges);

        // 4. Return the longest single leg (in edges) up to the parent
        return Math.max(leftEdges, rightEdges);
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxEdges;
    }
}