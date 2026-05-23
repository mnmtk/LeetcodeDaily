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
    int num;
    boolean root_check = true;

    public boolean isUnivalTree(TreeNode root) {

        if(root == null) return true;

        if(root_check) {
            num = root.val;
            root_check = false;
        }

        if(root.val != num) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}