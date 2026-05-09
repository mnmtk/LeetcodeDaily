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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(Math.abs(b - target), Math.abs(a - target))
        );

        dfs(root, target, k, pq);
        
        return new ArrayList<>(pq);
    }

    private void dfs(TreeNode node, double target, int k, PriorityQueue<Integer> pq) {
        if (node == null) return;

        pq.add(node.val);
        
        // If we have more than k elements, remove the one furthest from the target
        if (pq.size() > k) {
            pq.poll();
        }

        dfs(node.left, target, k, pq);
        dfs(node.right, target, k, pq);
    }
}