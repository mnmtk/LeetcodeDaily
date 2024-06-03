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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);  
    }

    boolean isValid(TreeNode root, long min, long max) {

        if(root.val >= max || root.val <= min) {
            return false;
        }

        if(root.left != null) {
            if(!isValid(root.left, min, root.val)) {
                return false;
            }
        }

            if(root.right != null) {
            if(!isValid(root.right, root.val, max)) {
                return false;
            }
        }

        return true;
    }
}