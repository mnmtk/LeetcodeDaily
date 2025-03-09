class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[rows][cols];

        queue.offer(new int[] {0, 0});
        visited[0][0] = health - grid.get(0).get(0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            
            int currHealth = visited[row][col];

            if (row == rows - 1 && col == cols - 1) {
                return true;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newHealth = currHealth - grid.get(newRow).get(newCol);
                    if (newHealth >= 0 && newHealth > visited[newRow][newCol]) {
                        visited[newRow][newCol] = newHealth;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
        
        return false;
    }
}