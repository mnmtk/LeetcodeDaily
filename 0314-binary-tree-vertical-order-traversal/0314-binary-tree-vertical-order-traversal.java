
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode node = curr.getKey();
            int col = curr.getValue();

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, col + 1));
            }
        }

        for (List<Integer> colList : map.values()) {
            ans.add(colList);
        }

        return ans;
    }
}
