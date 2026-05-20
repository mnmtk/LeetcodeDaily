/**
 * Definition for a binary tree node.
 * public class TreeNode 
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }

        insert(root, val, depth, 1);
        return root;
    }

    public void insert(TreeNode node, int val, int target, int depth) {

        if(node == null) return;

        if(depth == target - 1) {

            TreeNode nowLeft = node.left;
            TreeNode nowRight = node.right;

            TreeNode nodeLeft = new TreeNode(val);
            TreeNode nodeRight = new TreeNode(val);

            node.left = nodeLeft;
            nodeLeft.left = nowLeft;

            node.right = nodeRight;
            nodeRight.right = nowRight;

        } else {
            insert(node.left, val, target, depth+1);
            insert(node.right, val, target, depth + 1);
        }

        return;

    }
}