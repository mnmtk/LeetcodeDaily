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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            
            int size = q.size();

            while(size-- > 0) {
                TreeNode node = q.poll();

                if(node.left != null && node.right != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                } else {
                    if(node.left != null) {
                        ans.add(node.left.val);
                        q.offer(node.left);
                    }

                    if(node.right != null) {
                        ans.add(node.right.val);
                        q.offer(node.right);
                    }
                }
            }
        }

        return ans;
    }
}