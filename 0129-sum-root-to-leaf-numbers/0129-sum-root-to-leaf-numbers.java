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
    public int sumNumbers(TreeNode root) {

        int totalSum = 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode currNode = curr.getKey();
            int currSum = curr.getValue();

            if (currNode != null) {

                currSum = 10 * currSum + currNode.val;

                if (currNode.left == null && currNode.right == null) {
                    totalSum += currSum;
                } else {
                    stack.push(new Pair<>(currNode.left, currSum));
                    stack.push(new Pair<>(currNode.right, currSum));
                }
            }

        }

        return totalSum;
    }
}