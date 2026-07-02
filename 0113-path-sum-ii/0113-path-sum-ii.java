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
    private void recurseTree(
            TreeNode node,
            int remainingSum,
            List<Integer> pathNodes,
            List<List<Integer>> pathsList) {

        if (node == null) {
            return;
        }

        pathNodes.add(node.val);

        if (remainingSum == node.val && node.left == null && node.right == null) {
            
            pathsList.add(new ArrayList<>(pathNodes));

        } 

            this.recurseTree(
                    node.left,
                    remainingSum - node.val,
                    pathNodes,
                    pathsList);
            this.recurseTree(
                    node.right,
                    remainingSum - node.val,
                    pathNodes,
                    pathsList);
        


        pathNodes.remove(pathNodes.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;
    }
}