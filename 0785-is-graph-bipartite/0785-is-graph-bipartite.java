import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int u=0; u < graph.length; u++) {
            if(colors[u] == -1) {
                if(!bfs(u, graph, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int u, int[][] graph, int[] color, int col) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(u);
        color[u] = col;

        while(!q.isEmpty()) {
                int rmv = q.poll();
                for(int neighbor : graph[rmv]) {
                    if(color[neighbor] == -1) {
                        color[neighbor] = 1 - color[rmv];
                        q.offer(neighbor);
                    } else if (color[neighbor] == color[rmv]) {
                        return false;
                    }
                }
        }
        return true;
    }
}