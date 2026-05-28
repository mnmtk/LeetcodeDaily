/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        // Pass a StringBuilder to manage state efficiently
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        // Convert the integer (0-25) to its corresponding character ('a'-'z')
        sb.append((char) ('a' + node.val));

        // If it's a leaf node, process the string
        if (node.left == null && node.right == null) {
            // Reverse to get the leaf-to-root string
            sb.reverse();
            String current = sb.toString();
            
            // Undo the reverse so backtracking continues to work properly
            sb.reverse(); 

            // Update ans if it's empty, or if current is lexicographically smaller
            if (ans.isEmpty() || current.compareTo(ans) < 0) {
                ans = current;
            }
        }

        // Traverse left and right
        dfs(node.left, sb);
        dfs(node.right, sb);

        // Backtrack: Remove the current node's character before going back up the tree
        sb.deleteCharAt(sb.length() - 1);
    }
}