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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        if(root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDeleteSet = new HashSet<>();

        for(int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            if(currentNode.left != null) {
                queue.add(currentNode.left);

                if(toDeleteSet.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if(currentNode.right != null) {

                queue.add(currentNode.right);

                if(toDeleteSet.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            if(toDeleteSet.contains(currentNode.val)) {

                 if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }

        }

        if(!toDeleteSet.contains(root.val)) {
            forest.add(root);
            }
        

        return forest;
        
    }
}