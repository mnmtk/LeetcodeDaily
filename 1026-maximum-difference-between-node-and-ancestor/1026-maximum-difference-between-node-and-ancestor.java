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

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int prevMax, int prevMin) {

        if(root == null) return;

        int localans = Math.max(Math.abs(prevMax - root.val), Math.abs(prevMin - root.val));
        ans = Math.max(localans, ans);

        dfs(root.left, Math.max(prevMax, root.val) ,Math.min(prevMin, root.val));
        dfs(root.right, Math.max(prevMax, root.val) ,Math.min(prevMin, root.val));
    }


}