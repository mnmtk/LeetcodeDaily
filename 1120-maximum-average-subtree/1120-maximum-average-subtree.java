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
    Double ans = Double.MIN_VALUE;
    public class Node {
        Double avg;
        int count;

        Node(Double avg, int count) {
            this.avg = avg;
            this.count = count;
        }
    }

    public Node dfs(TreeNode root) {

        if(root == null) {
            return new Node(0.00, 0);
        }

        if(root.left == null && root.right == null) {
            ans = Math.max(root.val, ans);
            return new Node(Double.valueOf(root.val), 1);
        }

        Node left = dfs(root.left);
        Node right = dfs(root.right);


        Double val = left.avg * left.count + right.avg * right.count + root.val;
        int count = left.count + right.count + 1;
        Double avg = val/count;

        ans = Math.max(avg, ans);
        return new Node (Double.valueOf(avg), count);
    }

    public double maximumAverageSubtree(TreeNode root) {
       dfs(root);

       return ans;
    }
}