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
    public int dfs(TreeNode node) {

        if(node == null) return -1;

        int diameter = 0;
        
        int leftMax = 1 + dfs(node.left);
        int rightMax = 1 + dfs(node.right);

        diameter = leftMax + rightMax;

        ans = Math.max(diameter, ans);

        return Math.max(leftMax, rightMax);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}