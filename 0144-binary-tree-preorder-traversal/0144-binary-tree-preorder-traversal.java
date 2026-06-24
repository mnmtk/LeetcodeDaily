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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.add(root);

        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.add(curr.val);

            if (curr.right != null)
                stack.add(curr.right);
                
            if (curr.left != null)
                stack.add(curr.left);
                
        }

        return ans;

    }
}