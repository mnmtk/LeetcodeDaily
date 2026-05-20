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
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) {
        return null;
    }
    if (root.val >= L && root.val <= R) {
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
    } else if (root.val < L) {
        root = trimBST(root.right, L, R);
    } else if (root.val > R) {
        root = trimBST(root.left, L, R);
    }
    return root;
}
}