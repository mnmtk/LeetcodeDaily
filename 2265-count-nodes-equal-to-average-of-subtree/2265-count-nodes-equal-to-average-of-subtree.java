class Node {
    int avg;
    int nodes;

    Node(int avg, int nodes) {
        this.avg = avg;
        this.nodes = nodes;
    }
}

class Solution {
    int ans = 0; // Initialize our counter

    private Node average(TreeNode node) {
        // Base case: null nodes have 0 average and 0 nodes
        if (node == null) return new Node(0, 0);

        // 1. Recurse down to get data from children
        Node left = average(node.left);
        Node right = average(node.right);

        // 2. Reconstruct the total sum and total node count for THIS subtree
        int totalNodes = left.nodes + right.nodes + 1;
        int totalSum = (left.avg * left.nodes) + (right.avg * right.nodes) + node.val;
        
        // 3. Calculate the actual current average (integer division rounds down automatically)
        int currentAvg = totalSum / totalNodes;

        // 4. Your exact logic: Check if the CURRENT node matches its own subtree average
        if (node.val == currentAvg) {
            ans++;
        }

        // 5. Return the new Node object back up to the parent
        return new Node(currentAvg, totalNodes);
    }

    public int averageOfSubtree(TreeNode root) {
        average(root);
        return ans;
    }
}