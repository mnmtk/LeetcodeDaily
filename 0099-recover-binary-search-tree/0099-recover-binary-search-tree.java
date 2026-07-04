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
    TreeNode x = null;
    TreeNode y = null;
    TreeNode prev = null;
    public void swap(TreeNode root1, TreeNode root2) {
        int temp = root1.val;
        root1.val = root2.val;
        root2.val = temp;
    }

    public void recoverTree(TreeNode root) {
        findSwapped(root);
        swap(x, y);
    }

    public void findSwapped(TreeNode root) {
        if (root == null)
            return;

        findSwapped(root.left);
        if(prev != null && root.val < prev.val) {
            y = root;
            if(x == null) x = prev;
            else return;
        }
        prev = root; //imp.
        findSwapped(root.right);
    }
}