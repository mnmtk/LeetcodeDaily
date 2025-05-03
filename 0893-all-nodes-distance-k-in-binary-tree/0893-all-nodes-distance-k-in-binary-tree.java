/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfsBuild(root, null, graph);
        visited.add(target);
        // bfs(target, 0, graph);

        dfs(target, 0, graph);

        return ans;
    }

    public void bfs(TreeNode node, int dist, Map<TreeNode, List<TreeNode>> graph) { 

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(node, dist));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();

            TreeNode currNode = curr.getKey();
            dist = curr.getValue();

            if  (dist == k) ans.add(currNode.val); 

            for (TreeNode neigh : graph.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited.contains(neigh)) {
                    visited.add(neigh);
                    queue.add(new Pair<>(neigh, dist + 1));
                }
            }
        }
    }

    public void dfs(TreeNode node, int dist, Map<TreeNode, List<TreeNode>> graph) {
        if(dist == k) ans.add(node.val);

        for(TreeNode neigh : graph.getOrDefault(node, new ArrayList<>())) {
            if(!visited.contains(neigh)) {
                visited.add(neigh);
                dfs(neigh, dist + 1, graph);
            }
        }
    }

    public void dfsBuild(TreeNode curr, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (curr != null && parent != null) {
            graph.computeIfAbsent(curr, k -> new ArrayList<>()).add(parent);
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(curr);
        }

        if (curr != null && curr.left != null) {
            dfsBuild(curr.left, curr, graph);
        }

        if (curr != null && curr.right != null) {
            dfsBuild(curr.right, curr, graph);
        }
    }
}