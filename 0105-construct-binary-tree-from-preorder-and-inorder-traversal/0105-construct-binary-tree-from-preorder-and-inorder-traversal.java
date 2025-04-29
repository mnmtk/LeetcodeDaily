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
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length -1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pStart, int iStart, int iEnd) {
        if(iStart > iEnd || pStart >= preorder.length) {
            return null;
        }

        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = iStart;
        for(int i = iStart; i<= iEnd;i++) {
            if(inorder[i] == rootVal) {
                inorderIndex = i;
            };
        }
        int treeSize = inorderIndex - iStart;
        TreeNode left = buildTreeHelper(preorder, inorder, pStart + 1, iStart, inorderIndex - 1);
        TreeNode right = buildTreeHelper(preorder, inorder, pStart + treeSize + 1, inorderIndex + 1, iEnd);

        root.left = left;
        root.right = right;

        return root;
    }
}