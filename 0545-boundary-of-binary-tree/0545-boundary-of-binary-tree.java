/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;
        if (!isLeaf(root)) boundary.add(root.val);

        // Add left boundary excluding leaves
        addLeftBoundary(root.left, boundary);

        // Add leaves
        addLeaves(root, boundary);

        // Add right boundary excluding leaves in reverse order
        addRightBoundary(root.right, boundary);

        return boundary;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (!isLeaf(node)) boundary.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> boundary) {
        LinkedList<Integer> temp = new LinkedList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.addFirst(node.val);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        boundary.addAll(temp);
    }

    private void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }
}
