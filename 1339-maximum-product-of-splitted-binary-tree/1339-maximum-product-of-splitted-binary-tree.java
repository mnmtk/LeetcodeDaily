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

    List<Integer> allSum = new ArrayList<>();

    public int treeSum(TreeNode node) {

        if(node == null) return 0;

        int left = treeSum(node.left);
        int right = treeSum(node.right);
        int val = node.val;

        allSum.add(left + right + val);

        return left + right + val;
    }
    public int maxProduct(TreeNode root) {

        long max = 0;
        
        long fullSum = treeSum(root);

        for(long sum : allSum) {

            long each = sum * (fullSum - sum);
            max = Math.max(each, max);
        }

        return (int)(max % 1000000007);

    }
}