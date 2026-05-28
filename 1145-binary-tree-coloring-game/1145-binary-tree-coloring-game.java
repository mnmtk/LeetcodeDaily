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

    private int leftSize;
    private int rightSize;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        leftSize = 0;
        rightSize = 0;

        dfs(root,x);

        int up = n - (leftSize + rightSize + 1);
        int maxPart = Math.max(up,Math.max(leftSize,rightSize));

        return maxPart > n / 2;
    }

    private int dfs(TreeNode root,int x){
        if(root == null)
            return 0;

        int left = dfs(root.left,x);
        int right = dfs(root.right,x);

        if(root.val == x){
            leftSize = left;
            rightSize = right;
        }

        return left + right + 1;
    }
}