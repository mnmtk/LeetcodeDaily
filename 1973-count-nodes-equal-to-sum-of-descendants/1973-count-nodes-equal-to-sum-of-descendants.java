class Solution {
    int ans = 0; 

    public int equalToDescendants(TreeNode root) {
        calculateSubtreeSum(root);
        return ans;
    }


    private int calculateSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        
        int leftSum = calculateSubtreeSum(root.left);
        int rightSum = calculateSubtreeSum(root.right);


        if (leftSum + rightSum == root.val) {
            ans++;
        }


        return leftSum + rightSum + root.val;
    }
}