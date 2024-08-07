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

        int value = root.val;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        ans = Math.max(ans, left + right + value);

        return Math.max(left, right) + value;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
        
    }
}