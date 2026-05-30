import java.util.*;

class Solution {
    // Changed return type to NodeCopy
    public NodeCopy copyRandomBinaryTree(Node root) {
        // Edge case: if the tree is empty
        if (root == null) {
            return null;
        }

        // Map original 'Node' to cloned 'NodeCopy'
        Map<Node, NodeCopy> mapNewNodes = new HashMap<>();
        
        // Queue for BFS traversal of the original tree
        Queue<Node> queue = new LinkedList<>();

        // Initialize the root copy and add to queue
        mapNewNodes.put(root, new NodeCopy(root.val));
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            NodeCopy currNewNode = mapNewNodes.get(node);

            // Process Left Child
            if (node.left != null) {
                if (!mapNewNodes.containsKey(node.left)) {
                    mapNewNodes.put(node.left, new NodeCopy(node.left.val));
                    queue.offer(node.left);
                }
                currNewNode.left = mapNewNodes.get(node.left);
            }

            // Process Right Child
            if (node.right != null) {
                if (!mapNewNodes.containsKey(node.right)) {
                    mapNewNodes.put(node.right, new NodeCopy(node.right.val));
                    queue.offer(node.right);
                }
                currNewNode.right = mapNewNodes.get(node.right);
            }

            // Process Random Pointer
            if (node.random != null) {
                if (!mapNewNodes.containsKey(node.random)) {
                    mapNewNodes.put(node.random, new NodeCopy(node.random.val));
                    queue.offer(node.random); 
                }
                currNewNode.random = mapNewNodes.get(node.random);
            }
        }

        // Return the deep copy of the root (which is a NodeCopy)
        return mapNewNodes.get(root);
    }
}