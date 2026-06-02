class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // 1. Root is at Level 0 (Even). It must be ODD.
        if(root == null || root.val % 2 == 0) return false;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // FIX: The loop inspects the CHILDREN of the polled nodes.
        // The first children we inspect will be at Level 1 (an ODD level),
        // so we start our child-tracker flag at `false`.
        boolean nextLevelEven = false; 
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            // Next level is Even -> values must be ODD and INCREASING (start at MIN)
            // Next level is Odd  -> values must be EVEN and DECREASING (start at MAX)
            int latest = nextLevelEven ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
            
            while(size-- > 0) {
                TreeNode curr = queue.poll();

                if(curr.left != null) {
                    if (nextLevelEven) {
                        // Even level violation: value is not odd, OR failed to increase
                        if(curr.left.val % 2 == 0 || curr.left.val <= latest) return false;
                    } else {
                        // Odd level violation: value is not even, OR failed to decrease
                        if(curr.left.val % 2 != 0 || curr.left.val >= latest) return false;
                    }
                    queue.offer(curr.left);
                    latest = curr.left.val;
                }

                if(curr.right != null) {
                    if (nextLevelEven) {
                        // Even level violation: value is not odd, OR failed to increase
                        if(curr.right.val % 2 == 0 || curr.right.val <= latest) return false;
                    } else {
                        // Odd level violation: value is not even, OR failed to decrease
                        if(curr.right.val % 2 != 0 || curr.right.val >= latest) return false;
                    }
                    queue.offer(curr.right);
                    latest = curr.right.val;
                }
            }

            // Alternate the flag for the next level's children
            nextLevelEven = !nextLevelEven;
        }

        return true;
    }
}