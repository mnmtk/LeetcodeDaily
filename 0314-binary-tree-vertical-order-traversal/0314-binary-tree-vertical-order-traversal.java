class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;

     
        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        nodeQueue.add(root);
        colQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();


            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);


            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(col - 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(col + 1);
            }
        }


        for (List<Integer> column : map.values()) {
            output.add(column);
        }

        return output;
    }
}