class Solution {
    public static int[] dr = {0, -1, 1, 0};
    public static int[] dc = {1, 0, 0, -1};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n]; // Track visited cells
        boolean[][] currentPath = new boolean[m][n]; // Track cells in the current DFS path

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] != '-') {
                    if (dfs(i, j, -1, -1, grid, visited, currentPath, m, n)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int prevX, int prevY, char[][] grid, boolean[][] visited, boolean[][] currentPath, int m, int n) {
        visited[i][j] = true; // Mark as visited
        currentPath[i][j] = true; // Mark as part of the current path

        for (int x = 0; x < 4; x++) {
            int newX = i + dr[x];
            int newY = j + dc[x];

            if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                if (grid[i][j] != grid[newX][newY]) continue; // Check if characters match
                if (newX == prevX && newY == prevY) continue; // Skip immediate backtracking
                if (currentPath[newX][newY]) return true; // Check if already in the current path
                if (visited[newX][newY]) continue; // Skip if visited but not in the current path
                if (dfs(newX, newY, i, j, grid, visited, currentPath, m, n)) return true;
            }
        }

        currentPath[i][j] = false; // Unmark from the current path after exploring neighbors

        return false;
    }
}
