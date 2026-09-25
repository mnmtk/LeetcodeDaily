import java.util.*;

class Solution {
    private int[] vis;
    private List<Integer>[] g;
    private List<Integer> seq;


    public int minRunesToAdd(int n, int[] crystals, int[] flowFrom, int[] flowTo) {
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < flowFrom.length; ++i) {
            g[flowFrom[i]].add(flowTo[i]);
        }

        vis = new int[n];
        seq = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        // Step 1: Multi-source BFS from all nodes containing a magic crystal
        for (int i : crystals) {
            vis[i] = 1;
            q.offer(i);
        }
        bfs(q);

        // Step 2: DFS to record post-order finish times for unreached nodes
        for (int i = 0; i < n; ++i) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }

        // Step 3: Greedily process components in reverse post-order
        int ans = 0;
        for (int i = seq.size() - 1; i >= 0; --i) {
            int a = seq.get(i);
            if (vis[a] == 2) { // Found a root/leader of an unsatisfied component
                vis[a] = 1;
                q.clear();
                q.offer(a);
                bfs(q); // Power everything this new rune can reach
                ++ans;
            }
        }
        
        return ans;
    }

    private void bfs(Deque<Integer> q) {
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int b : g[a]) {
                if (vis[b] == 1) continue;
                vis[b] = 1;
                q.offer(b);
            }
        }
    }

    private void dfs(int a) {
        vis[a] = 2; // Marked as currently visiting / visited in DFS pass
        for (int b : g[a]) {
            if (vis[b] > 0) continue;
            dfs(b);
        }
        seq.add(a); // Post-order tracking
    }
}