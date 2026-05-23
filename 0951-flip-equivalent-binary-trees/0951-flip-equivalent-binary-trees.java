class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: both are null, so they are equivalent
        if (root1 == null && root2 == null) return true;
        
        // Base case: one is null or the values don't match
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        
        // Option 1: The children match perfectly without flipping
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        
        // Option 2: The children match if we flip them
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        // It's equivalent if either option works!
        return noFlip || flip;
    }
}