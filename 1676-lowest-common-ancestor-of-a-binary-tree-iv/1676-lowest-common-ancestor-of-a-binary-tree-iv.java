import java.util.HashSet;
import java.util.Set;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // Convert the array to a HashSet for O(1) lookups
        Set<TreeNode> targetNodes = new HashSet<>();
        for (TreeNode node : nodes) {
            targetNodes.add(node);
        }
        
        return dfs(root, targetNodes);
    }
    
    private TreeNode dfs(TreeNode root, Set<TreeNode> targetNodes) {
        // Base cases: if we hit null or find one of our target nodes
        if (root == null || targetNodes.contains(root)) {
            return root;
        }
        
        // Search left and right subtrees
        TreeNode left = dfs(root.left, targetNodes);
        TreeNode right = dfs(root.right, targetNodes);
        
        // If targets are found in both subtrees, the current node is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null side (if any)
        return left != null ? left : right;
    }
}