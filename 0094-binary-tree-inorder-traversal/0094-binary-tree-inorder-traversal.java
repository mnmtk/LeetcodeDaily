/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
              
                // If no left child, visit this node 
                // and go right
                res.add(curr.val);
                curr = curr.right;
            } 
            else {
              
                // Find the inorder predecessor of curr
                TreeNode prev = curr.left;
                while (prev.right != null && 
                                   prev.right != curr) {
                    prev = prev.right;
                }

                // Make curr the right child of its 
                // inorder predecessor
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } 
                else {
                  
                    // Revert the changes made in 
                    // the tree structure
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;

    }
}