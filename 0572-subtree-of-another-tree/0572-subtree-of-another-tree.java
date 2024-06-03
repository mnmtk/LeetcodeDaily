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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(SameTree(node, subRoot)) {
                return true;
            }
            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }            
        }

        return false;
    }

    boolean SameTree(TreeNode a, TreeNode b) {

        if(a == null && b == null) {
            return true;
        } 

        if(a == null || b == null) {
            return false;
        }

        if(a.val != b.val) {
            return false;
        }

        return SameTree(a.left, b.left) && SameTree(a.right, b.right);
        
    }
}