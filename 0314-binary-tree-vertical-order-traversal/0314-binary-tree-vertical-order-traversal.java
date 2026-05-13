import java.util.*;

class Solution {
    // We track the range of columns to avoid sorting the map keys later
    int min = 0;
    int max = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // Map to store column index -> list of node values
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        bfs(root, map);

        // Iterate from the leftmost column to the rightmost column
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                ans.add(map.get(i));
            }
        }

        return ans;
    }

    private void bfs(TreeNode root, Map<Integer, List<Integer>> map) {
        // Queue stores pairs of {Node, Column Index}
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode currNode = curr.getKey();
            int column = curr.getValue();

            // Update the global min/max column bounds
            min = Math.min(min, column);
            max = Math.max(max, column);

            // Add value to the corresponding column list
            map.computeIfAbsent(column, k -> new ArrayList<>()).add(currNode.val);

            // Left child goes to column - 1, Right child goes to column + 1
            if (currNode.left != null) {
                queue.offer(new Pair<>(currNode.left, column - 1));
            }
            if (currNode.right != null) {
                queue.offer(new Pair<>(currNode.right, column + 1));
            }
        }
    }
}