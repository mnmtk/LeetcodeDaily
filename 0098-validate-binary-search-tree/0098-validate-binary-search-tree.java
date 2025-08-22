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
        return isValidSubTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidSubTree(TreeNode root, Long min, Long max) {
        if(root.val <= min || root.val >= max) return false;

        if(root.left != null) {
        if(!isValidSubTree(root.left, min, (long) root.val)) return false;
        }
        
        if(root.right != null) {
        if(!isValidSubTree(root.right, (long) root.val, max)) return false;
        }

        return true;
    }
}