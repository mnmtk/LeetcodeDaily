class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the node is null, we've reached a dead end.
        if (root == null) {
             return false;
        }
        
        // Base case: if it is a leaf node, check if its value equals the remaining target sum.
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        // Subtract the current node's value from the target for the next level
        int remainingSum = targetSum - root.val;
        
        // Recursively check the left and right subtrees. 
        // If either path returns true, the result is true.
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}