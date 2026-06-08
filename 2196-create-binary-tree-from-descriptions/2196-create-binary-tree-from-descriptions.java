import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
     
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> potentialRoots = new HashSet<>();
        Set<Integer> allChildren = new HashSet<>();

        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            boolean isLeft = des[2] == 1;

            // Compute nodes efficiently
            TreeNode parentNode = map.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode childNode = map.computeIfAbsent(childVal, TreeNode::new);

            // Assign structure
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Track root candidates
            allChildren.add(childVal);
            potentialRoots.remove(childVal); // A child can never be the root
            
            if (!allChildren.contains(parentVal)) {
                potentialRoots.add(parentVal); // Only a candidate if it isn't already a known child
            }
        }

        // The remaining element in potentialRoots is exactly our root node
        int rootVal = potentialRoots.iterator().next();
        return map.get(rootVal);
    }
}