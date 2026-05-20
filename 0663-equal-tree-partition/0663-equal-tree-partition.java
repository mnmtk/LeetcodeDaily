class Solution {
    public boolean checkEqualTree(TreeNode root) {
        // This list will store the sum of every subtree *except* the absolute root
        List<Integer> allSubtreeSums = new ArrayList<>();
        
        // Run DFS to calculate the total sum and populate our list
        int totalSum = dfs(root, allSubtreeSums, true);
        
        // If the total sum is odd, it's impossible to split it equally into two integers
        if (totalSum % 2 != 0) {
            return false;
        }
        
        // Check if our list contains exactly half of the total sum
        int target = totalSum / 2;
        return allSubtreeSums.contains(target);
    }

    private int dfs(TreeNode node, List<Integer> allSubtreeSums, boolean isRoot) {
        if (node == null) {
            return 0;
        }
        
        // Post-order traversal: Get the sum of left and right child trees first
        int leftSum = dfs(node.left, allSubtreeSums, false);
        int rightSum = dfs(node.right, allSubtreeSums, false);
        
        // Total sum of the current subtree
        int currentSum = leftSum + rightSum + node.val;
        
        // We can only partition the tree at this edge if it's NOT the root node
        if (!isRoot) {
            allSubtreeSums.add(currentSum);
        }
        
        return currentSum;
    }
}