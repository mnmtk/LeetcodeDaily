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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper()
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int startIn, int endIn, int preStart) {

        if (startIn > endIn || pStart >= preorder.length) {
            return null;
        }

        int rootVal = preorder[preStart];
        int root = new TreeNode(rootVal);

        int inOrderIndex = startIn;
        for (int i = startIn; i < endIn; i++) {
            if (inorder[i] == inOrderIndex) {
                inOrderIndex = i;
            }
        }

        int treeSize = inorderIndex - iStart;
        TreeNode left = buildTreeHelper(preorder, inorder, pStart + 1, iStart, inorderIndex - 1);
        TreeNode right = buildTreeHelper(preorder, inorder, pStart + treeSize + 1, inorderIndex + 1, iEnd);
        root.left = left;
        root.right = right;

        return root;
    }
}