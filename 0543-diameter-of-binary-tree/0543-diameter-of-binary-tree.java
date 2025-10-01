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
    int ans = 0;
    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int dia = left + right;
        ans = Math.max(dia, ans);

        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}