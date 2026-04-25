class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode first = null, last = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            first = queue.peek();
            while(size-- > 0){
                last = queue.remove();
                if(last.left != null) queue.add(last.left);
                if(last.right != null) queue.add(last.right);
            }
        }
        return lcs(root, first.val, last.val);
    }
    public TreeNode lcs(TreeNode root, int n1, int n2){
        if(root == null) return null;
        if(root.val == n1 || root.val == n2){
            return root;
        }
        TreeNode left = lcs(root.left, n1, n2);
        TreeNode right = lcs(root.right, n1, n2);

        if(left != null && right != null) return root;

        if(left != null) return left;
        else return right;
    }
}