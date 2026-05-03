import java.util.*;

class Solution {
    // We change the Map to store a custom object or Pair to keep track of the row
    Map<Integer, List<int[]>> answer = new TreeMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answerValues = new ArrayList<>();
        if (root == null) return answerValues;

        dfs(root, 0, 0);

        for (int key : answer.keySet()) {
            List<int[]> columnNodes = answer.get(key);
            columnNodes.sort((a, b) -> a[1] - b[1]);

            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] nodeInfo : columnNodes) {
                sortedColumn.add(nodeInfo[0]);
            }
            answerValues.add(sortedColumn);
        }
       
       return answerValues;
    }

    private void dfs(TreeNode root, int colindex, int rowindex) {
        if (root == null) return;

        // Store as {value, rowindex}
        answer.computeIfAbsent(colindex, k -> new ArrayList<>())
              .add(new int[]{root.val, rowindex});

        // Traverse left then right
        dfs(root.left, colindex - 1, rowindex + 1);
        dfs(root.right, colindex + 1, rowindex + 1);
    }
}