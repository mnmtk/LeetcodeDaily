class Solution {
    // Self-documenting constants
    private static final int START = 1;
    private static final int DESTINATION = 2;
    private static final int EMPTY = 0;
    private static final int OBSTACLE = -1;

    //self made
    private static final int VISITED = -2;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startRow = 0, startCol = 0;
        int cellsToVisit = 0;

        // 1. Find start position and count total walkable cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != OBSTACLE) {
                    cellsToVisit++; // Includes start, empty cells, and destination
                }
                if (grid[r][c] == START) {
                    startRow = r;
                    startCol = c;
                }
            }
        }

        return backtrack(grid, startRow, startCol, cellsToVisit);
    }

    private int backtrack(int[][] grid, int row, int col, int remaining) {
        // Base case: Reached destination
        if (grid[row][col] == DESTINATION) {
            // Path is valid only if every walkable cell was visited (remaining should be 1 for dest cell)
            return remaining == 1 ? 1 : 0;
        }

        // Save original value to restore during unmarking
        int temp = grid[row][col];
        grid[row][col] = VISITED;
        remaining--;

        int validPaths = 0;

        // Explore all 4 orthogonal directions
        for (int[] dir : DIRECTIONS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (isValid(grid, nextRow, nextCol)) {
                validPaths += backtrack(grid, nextRow, nextCol, remaining);
            }
        }

        // Unmark (backtrack step)
        grid[row][col] = temp;

        return validPaths;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        boolean inBounds = r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
        if (!inBounds) return false;

        // Cannot step onto obstacles or already visited cells
        return grid[r][c] != OBSTACLE && grid[r][c] != VISITED;
    }
}