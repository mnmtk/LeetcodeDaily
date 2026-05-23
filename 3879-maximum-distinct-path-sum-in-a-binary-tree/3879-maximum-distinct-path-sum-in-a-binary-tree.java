import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    private int maxGlobalSum = Integer.MIN_VALUE;

    public int maxSum(TreeNode root) {
        if (root == null) return 0;
        maxGlobalSum = Integer.MIN_VALUE;

        // Step 1: Map every node to its parent so we can travel upwards
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        // Step 2: Use a single HashSet to track values on our active backtracking path
        HashSet<Integer> visitedValues = new HashSet<>();

        // Step 3: Launch a path exploration from EVERY single node as a starting point
        exploreFromAllNodes(root, parentMap, visitedValues);

        return maxGlobalSum;
    }

    // Helper to link child nodes to their direct parents
    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        
        if (parent != null) {
            parentMap.put(node, parent);
        }
        
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    // Helper to systematically kick off a DFS from every node in the tree
    private void exploreFromAllNodes(TreeNode node, Map<TreeNode, TreeNode> parentMap, HashSet<Integer> visitedValues) {
        if (node == null) return;

        // Treat the current node as the starting point (origin) of a new path
        dfsExplorer(node, null, 0, parentMap, visitedValues);

        // Recurse to ensure we also test starting paths from all children
        exploreFromAllNodes(node.left, parentMap, visitedValues);
        exploreFromAllNodes(node.right, parentMap, visitedValues);
    }

    // The backtracking explorer that moves in 3 directions: left, right, and up
    private void dfsExplorer(TreeNode current, TreeNode cameFrom, int currentSum, 
                             Map<TreeNode, TreeNode> parentMap, HashSet<Integer> visitedValues) {
        
        // If the node's value is already in our path, this entire path sequence is invalid
        if (visitedValues.contains(current.val)) {
            return;
        }

        // --- BACKTRACKING: CHOOSE ---
        visitedValues.add(current.val);
        currentSum += current.val;

        // Update our absolute global maximum path sum
        maxGlobalSum = Math.max(maxGlobalSum, currentSum);

        // --- EXPLORE DIRECTION 1: Down-Left ---
        if (current.left != null && current.left != cameFrom) {
            dfsExplorer(current.left, current, currentSum, parentMap, visitedValues);
        }

        // --- EXPLORE DIRECTION 2: Down-Right ---
        if (current.right != null && current.right != cameFrom) {
            dfsExplorer(current.right, current, currentSum, parentMap, visitedValues);
        }

        // --- EXPLORE DIRECTION 3: Up to Parent ---
        TreeNode parentNode = parentMap.get(current);
        if (parentNode != null && parentNode != cameFrom) {
            dfsExplorer(parentNode, current, currentSum, parentMap, visitedValues);
        }

        // --- BACKTRACKING: UNCHOOSE ---
        visitedValues.remove(current.val);
    }
}