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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum =0;

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {

        TreeNode node = stack.pop();
        if(node != null && low <=node.val && node.val <= high) {
                sum += node.val;
        }

            if(node != null && low < node.val) {
                stack.push(node.left);
            }

            if(node != null && high > node.val) {
                stack.push(node.right);
            }
        }

        return sum;
    }
}