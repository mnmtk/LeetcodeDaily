import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            boolean isLeft = des[2] == 1;

            // 1. Get or create the parent node
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parentNode = map.get(parentVal);

            // 2. Get or create the child node
            map.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode childNode = map.get(childVal);

            // 3. Connect parent to child
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // 4. Mark this node as a child
            children.add(childVal);
        }

        // 5. The root is the parent node that never appeared in the children set
        for (int[] des : descriptions) {
            int parentVal = des[0];
            if (!children.contains(parentVal)) {
                return map.get(parentVal);
            }
        }

        return null;
    }
}