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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return check(root, 0, arr);
    }

    private boolean check(TreeNode root, int index, int[] arr) {

        if (root == null || index >= arr.length) {
            return false;
        }

        if (arr[index] != root.val)
            return false;


        if (index == arr.length - 1) {
            if (root.left == null && root.right == null)
                return true;
            else return false;
        }

        
        return check(root.left, index + 1, arr) || check(root.right, index + 1, arr);
    }
}