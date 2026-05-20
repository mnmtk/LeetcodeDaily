class Solution {
    int[] sums = new int[10001];
    int index = 0;

    public boolean checkEqualTree(TreeNode root) {
        index = 0; // Reset for LeetCode's test runner
        int total = dfs(root);
        
        // Pop the root (the last element added)
        index--; 
        
        if (total % 2 == 0) {
            int target = total / 2;
            // Raw array iteration is the fastest possible operation in Java
            for (int i = 0; i < index; i++) {
                if (sums[i] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int sum = node.val + dfs(node.left) + dfs(node.right);
        sums[index++] = sum;
        return sum;
    }
}