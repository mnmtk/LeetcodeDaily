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
    int ans;
    public int dfs(TreeNode node) {

        if( node == null) return -1;

        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;

        ans = Math.max(left + right, ans);

        return Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}