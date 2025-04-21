class Solution {
    public int findCircleNum(int[][] isConnected) {
        int total = isConnected.length;
        DisjointUnion dsu = new DisjointUnion(total);

        for (int i = 0; i < total; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    if (dsu.union(i  + 1, j + 1)) total--;
                }
            }
        }

        return total;
    }

    public class DisjointUnion {
        int[] parent;
        int[] rank;

        DisjointUnion(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);  // path compression
        }

        boolean union(int u, int v) {
            int u1 = find(u);
            int v1 = find(v);

            if (u1 == v1) return false;

            if (rank[u1] > rank[v1]) {
                rank[u1] += rank[v1];
                parent[v1] = u1;
            } else {
                rank[v1] += rank[u1];
                parent[u1] = v1;
            }

            return true;
        }
    }
}
