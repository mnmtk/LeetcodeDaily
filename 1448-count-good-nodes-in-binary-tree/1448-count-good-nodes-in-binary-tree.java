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
    int ans;

    public void traverseToCount(TreeNode root, int prevMax) {

        if(root == null) return;

         if(root.val >= prevMax) {
            ans++;
            prevMax = root.val;
        }
        

        traverseToCount(root.left, prevMax);
        traverseToCount(root.right, prevMax);

       
    }

    public int goodNodes(TreeNode root) {
        traverseToCount(root, Integer.MIN_VALUE);
        return ans;
    }
}