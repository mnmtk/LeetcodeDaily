/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null || root == p || root == q) return root;
// check even if at root

        TreeNode lca = LCA(root, p, q);

        if(lca == p) {
            return dfs(p, q) ? lca : null;
        } else if (lca == q) {
            return dfs(q, p) ? lca : null;
        }

        return lca;
    }

      public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;

    }

    private boolean dfs(TreeNode root, TreeNode target) {
        
        if(root == target) return true;

        if (root == null) return false;

        boolean left = dfs(root.left, target);
        boolean right = dfs(root.right, target);
        
        return left || right;
    }
}