class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;   
        }
        while(!isLeaf(root)) { //multiple calls to same tree!
            bfs(root, res);
        }
        res.add(Arrays.asList(root.val)); // Now the root is a leaf.
        return res;
    }
    
    /*
        Collect leaf values and put it in a list.
    */
    private void bfs(TreeNode n, List<List<Integer>> res) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(n);

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if(isLeaf(cur.left)) {
                list.add(cur.left.val);
                cur.left = null;
            } else if(cur.left != null) {
                queue.offer(cur.left);   
            }
            if(isLeaf(cur.right)) {
                list.add(cur.right.val);
                cur.right = null;
            } else if(cur.right != null) {
                queue.offer(cur.right);   
            }
        }

        res.add(list);
    }
    
    private boolean isLeaf(TreeNode n) {
        return n != null && n.left == null && n.right == null;   
    }
}