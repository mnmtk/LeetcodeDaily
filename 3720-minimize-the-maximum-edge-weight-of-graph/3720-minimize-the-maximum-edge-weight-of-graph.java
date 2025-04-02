import java.util.*;

class Solution {
    private int dfs(int i, int m, List<List<Pair>> ral, boolean[] vis) {
        int res = 1;
        vis[i] = true;
        
        for (Pair p : ral.get(i)) {
            int j = p.node;
            int w = p.weight;
            if (w <= m && !vis[j]) {
                res += dfs(j, m, ral, vis);
            }
        }
        return res;
    }

    public int minMaxWeight(int n, int[][] edges, int threshold) {
        // Build reverse adjacency list
        List<List<Pair>> ral = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ral.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            ral.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        // Binary search setup
        int l = 1, r = 1000001;
        while (l < r) {
            int m = (l + r) / 2;
            boolean[] vis = new boolean[n];
            if (dfs(0, m, ral, vis) == n) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l == 1000001 ? -1 : l;
    }

    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}