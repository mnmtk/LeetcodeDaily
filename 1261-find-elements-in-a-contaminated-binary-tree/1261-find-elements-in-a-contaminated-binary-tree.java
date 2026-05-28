class FindElements {
    private TreeNode root;

    public FindElements(TreeNode root) {
        // We don't even need to recover the tree values if we use the bit-path method!
        this.root = root;
    }
    
    public boolean find(int target) {
        // Map target to the 1-based binary indexing system
        int label = target + 1;
        
        // Find the highest set bit (MSB) position
        // e.g., for 6 (110), highestBit is 4 (100)
        int highestBit = Integer.highestOneBit(label);
        
        TreeNode curr = root;
        
        // Move from the second highest bit down to the lowest bit
        for (int shift = highestBit >> 1; shift > 0; shift >>= 1) {
            if (curr == null) return false;
            
            // Check if the bit at the current position is set (1) or not (0)
            if ((label & shift) == 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        
        return curr != null;
    }
}