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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        left.add(root.val);
        
        boolean leftIsNull = root.left == null;
        boolean rightIsNull = root.right == null;
        int leafCount = 0;

        while(!q.isEmpty() && leafCount != q.size())
        {
            int size = q.size();
            leafCount = 0;
            for(int i=0; i < size; i++)
            {
                TreeNode node = q.poll();
                if(node.left == null && node.right == null)
                {
                    q.offer(node);
                    leafCount++;
                    continue;
                }

                if(node.left != null)
                    q.offer(node.left);
                
                if(node.right != null)
                    q.offer(node.right);
                
                if(node != root)
                {
                    if(i==0 && !leftIsNull)
                        left.add(node.val);
                        
                    else if(i == size-1 && !rightIsNull)
                        right.addFirst(node.val);
                }   
            }
        }

        while(!q.isEmpty() && q.peek() != root)
            left.add(q.poll().val);

        left.addAll(right);
        return left;
    }
}