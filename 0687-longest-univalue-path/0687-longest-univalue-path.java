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

    int maxEdges = 0;


    int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);


        int leftEdges = 0;
        int rightEdges = 0;

        if (root.left != null && root.left.val == root.val) {
            leftEdges = leftPath + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            rightEdges = rightPath + 1;
        }

        maxEdges = Math.max(maxEdges, leftEdges + rightEdges);

        return Math.max(leftEdges, rightEdges);
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxEdges;
    }
}