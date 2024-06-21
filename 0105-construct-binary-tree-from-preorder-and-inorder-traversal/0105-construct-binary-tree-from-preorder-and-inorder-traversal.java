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
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1 );
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pStart, int inStart, int inEnd) {
        if(inStart > inEnd || pStart >= preorder.length) {
            return null;
        }

        int rootval = preorder[pStart];
        TreeNode node = new TreeNode(rootval);

        int inIndex = inStart;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootval) {
                inIndex = i;
                break;
            }
        }

        int treeLength = inIndex - inStart;

        node.left = buildTreeHelper(preorder, inorder, pStart + 1, inStart, inIndex -1);
        node.right = buildTreeHelper(preorder, inorder, pStart + 1 + treeLength, inIndex +1, inEnd);

        return node;
    }
}