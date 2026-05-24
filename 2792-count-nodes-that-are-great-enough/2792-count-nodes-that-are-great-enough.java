import java.util.*;

class Solution {
    int ans = 0;
    int kVal;

    public PriorityQueue<Integer> dfs(TreeNode root) {
        // Base Case: An empty node has no elements under it
        if (root == null) {
            return new PriorityQueue<>(Collections.reverseOrder());
        }

        // 1. Collect the smallest elements from left and right subtrees
        PriorityQueue<Integer> leftHeap = dfs(root.left);
        PriorityQueue<Integer> rightHeap = dfs(root.right);

        // 2. Merge the right heap into the left heap, keeping size bounded by k
        while (!rightHeap.isEmpty()) {
            leftHeap.offer(rightHeap.poll());
            if (leftHeap.size() > kVal) {
                leftHeap.poll(); // Discard the largest element if we exceed k
            }
        }

        // 3. Evaluation: Does this subtree contain k elements strictly smaller than root.val?
        // Because leftHeap is a Max-Heap capped at size k, its peek() element is the LARGEST
        // of the k smallest elements. If root.val is greater than that peek() element,
        // it means root.val is greater than all k elements in the heap!
        if (leftHeap.size() == kVal && root.val > leftHeap.peek()) {
            ans++;
        }

        // 4. Add the current node's value into the mix for its parent to evaluate
        leftHeap.offer(root.val);
        if (leftHeap.size() > kVal) {
            leftHeap.poll(); // Keep it lean before returning up the call stack
        }

        return leftHeap;
    }

    public int countGreatEnoughNodes(TreeNode root, int k) {
        this.ans = 0;      // Reset state for multiple test runs
        this.kVal = k;
        dfs(root);
        return ans;
    }
}