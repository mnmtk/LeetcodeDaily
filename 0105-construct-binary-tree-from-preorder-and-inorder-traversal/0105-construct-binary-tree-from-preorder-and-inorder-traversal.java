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
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pStart, int inStart, int inEnd) {
        if (pStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {  
            if (inorder[i] == rootVal) {
                inIndex = i;
                break; 
            }
        }

        int leftTreeSize = inIndex - inStart;
        root.left = buildTreeHelper(preorder, inorder, pStart + 1, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, pStart + 1 + leftTreeSize, inIndex + 1, inEnd);

        return root;
    }
}
