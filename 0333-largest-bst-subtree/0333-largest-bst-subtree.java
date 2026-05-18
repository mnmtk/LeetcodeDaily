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

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        int leftMax = findMax(root.left);
        if (leftMax >= root.val)
            return false;

        int rightMin = findMin(root.right);
        if (rightMin <= root.val)
            return false;

        if (isValidBST(root.left) && isValidBST(root.right)) {
            return true;
        }

        return false;

    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(Math.max(root.val, findMax(root.left)), findMax(root.right));
    }

    private int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(Math.min(root.val, findMin(root.left)), findMin(root.right));
    }

    private int countNodes(TreeNode root) {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isValidBST(root)) {
            return countNodes(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}