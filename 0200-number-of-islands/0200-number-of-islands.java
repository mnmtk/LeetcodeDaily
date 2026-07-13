class Solution {

    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, char[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();

        grid[i][j] = 'x';                  // sink at enqueue
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                if (grid[nr][nc] != '1') continue;

                grid[nr][nc] = 'x';        // sink BEFORE enqueue
                q.offer(new int[]{nr, nc});
            }
        }
    }

    
}