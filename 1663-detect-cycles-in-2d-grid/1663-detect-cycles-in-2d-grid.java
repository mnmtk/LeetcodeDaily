class Solution {
    public static int[] dr = {0, -1, 1, 0};
    public static int[] dc = {1, 0, 0, -1};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n]; // 0: not visited, 1: visited but not in current path, 2: in current path

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] != '-') {
                    if (dfs(i, j, -1, -1, grid, visited, m, n)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int prevX, int prevY, char[][] grid, int[][] visited, int m, int n) {
        visited[i][j] = 2; // Mark as part of the current path

        for (int x = 0; x < 4; x++) {
            int newX = i + dr[x];
            int newY = j + dc[x];

            if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                if (grid[i][j] != grid[newX][newY]) continue; // Check if characters match
                if (newX == prevX && newY == prevY) continue; // Skip immediate backtracking
                if (visited[newX][newY] == 2) return true; // Check if already in the current path
                if (visited[newX][newY] == 1) continue; // Skip if visited but not in the current path
                if (dfs(newX, newY, i, j, grid, visited, m, n)) return true;
            }
        }

        visited[i][j] = 1; // Mark as visited but not in the current path after exploring neighbors

        return false;
    }
}
