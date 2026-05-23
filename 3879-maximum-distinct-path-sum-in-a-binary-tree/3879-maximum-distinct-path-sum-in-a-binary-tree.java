import java.util.*;

class Solution {
    private int maxGlobalSum = Integer.MIN_VALUE;
    private List<List<Integer>> adj;
    private int[] vals;

    public int maxSum(TreeNode root) {
        if (root == null) return 0;
        maxGlobalSum = Integer.MIN_VALUE;

        // Step 1: Flatten the binary tree into a standard undirected graph adjacency list
        adj = new ArrayList<>();
        List<Integer> valuesList = new ArrayList<>();
        
        buildGraph(root, -1, valuesList);
        
        int n = adj.size();
        vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = valuesList.get(i);
        }

        // Step 2: Run a backtracking distinct path explorer from EVERY node in the tree
        HashSet<Integer> visitedValues = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfsExplorer(i, -1, 0, visitedValues);
        }

        return maxGlobalSum;
    }

    // Converts Binary Tree to general graph Adjacency List
    private void buildGraph(TreeNode node, int parentIdx, List<Integer> valuesList) {
        if (node == null) return;

        int currentIdx = adj.size();
        adj.add(new ArrayList<>());
        valuesList.add(node.val);

        if (parentIdx != -1) {
            adj.get(currentIdx).add(parentIdx);
            adj.get(parentIdx).add(currentIdx);
        }

        buildGraph(node.left, currentIdx, valuesList);
        buildGraph(node.right, currentIdx, valuesList);
    }

    // Straightforward, bulletproof graph backtracking dfs
    private void dfsExplorer(int u, int parent, int currentSum, HashSet<Integer> visitedValues) {
        // If the value is already in our path bag, this route is invalid
        if (visitedValues.contains(vals[u])) {
            return;
        }

        // Add to bag
        visitedValues.add(vals[u]);
        currentSum += vals[u];

        // Challenge the global absolute maximum
        maxGlobalSum = Math.max(maxGlobalSum, currentSum);

        // Continue extending the distinct path to any connected neighbors
        for (int neighbor : adj.get(u)) {
            if (neighbor != parent) {
                dfsExplorer(neighbor, u, currentSum, visitedValues);
            }
        }

        // Backtrack
        visitedValues.remove(vals[u]);
    }
}