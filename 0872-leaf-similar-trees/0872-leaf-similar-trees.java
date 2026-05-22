import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeafSequenceIterative(root1);
        List<Integer> leaves2 = getLeafSequenceIterative(root2);
        
        return leaves1.equals(leaves2);
    }
    
    private List<Integer> getLeafSequenceIterative(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        if (root == null) return leaves;
        
        // Using a Stack instead of a Queue forces Depth-First behavior
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            // Check if it's a leaf node
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }
            
            // CRITICAL: Push right child first, so left child is popped first!
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return leaves;
    }
}