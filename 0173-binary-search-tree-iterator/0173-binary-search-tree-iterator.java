class BSTIterator {

    private TreeNode curr;

    public BSTIterator(TreeNode root) {
        // Initialize the current pointer to the root
        this.curr = root;
    }
    
    public int next() {
        int result = -1;
        
        while (curr != null) {
            if (curr.left == null) {
                // No left child: visit this node, then move to the right child
                result = curr.val;
                curr = curr.right;
                break; // Pause the traversal here and return the result
            } else {
                // Find the inorder predecessor of current
                TreeNode pre = curr.left;
                
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                
                if (pre.right == null) {
                    // Make current as the right child of its inorder predecessor
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // Revert the changes made to the tree (restore the original tree)
                    pre.right = null;
                    result = curr.val;
                    curr = curr.right;
                    break; // Pause the traversal here and return the result
                }
            }
        }
        
        return result;
    }
    
    public boolean hasNext() {
        return curr != null;
    }
}