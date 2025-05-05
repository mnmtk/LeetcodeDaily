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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        int turn = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
           List<Integer> currentLevelValues = new ArrayList<Integer>();
           int length = queue.size();

           while(length--> 0) {
             TreeNode currentNode = queue.poll();
             currentLevelValues.add(currentNode.val);

             //left
             if(currentNode.left != null) {
                 queue.offer(currentNode.left);
             }

             //right
             if(currentNode.right != null) {
                 queue.offer(currentNode.right);
             }

           } 
           

          if(turn % 2 != 0) Collections.reverse(currentLevelValues);
          result.add(currentLevelValues);
          turn++;
        }

        return result;

    }
}