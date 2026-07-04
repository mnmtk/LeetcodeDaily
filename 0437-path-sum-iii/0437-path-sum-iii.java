class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        // 1. Paths starting at the current root
        int pathsFromRoot = countPathsFromNode(root, targetSum);
        
        // 2. Paths starting somewhere in the left subtree
        int pathsFromLeft = pathSum(root.left, targetSum);
        
        // 3. Paths starting somewhere in the right subtree
        int pathsFromRight = pathSum(root.right, targetSum);
        
        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }

    private int countPathsFromNode(TreeNode node, long currentSum) {
        if (node == null) return 0;
        
        int count = 0;
        // If the current node completes the sum, increment count
        if (node.val == currentSum) {
            count++;
        }
        
        // Continue down both paths, always subtracting the node's value
        // Note: We use 'long' for currentSum to prevent integer overflow in deep trees
        count += countPathsFromNode(node.left, currentSum - node.val);
        count += countPathsFromNode(node.right, currentSum - node.val);
        
        return count;
    }
}