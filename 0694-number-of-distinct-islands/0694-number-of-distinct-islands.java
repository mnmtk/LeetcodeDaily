import java.util.*;

class Solution {
    List<int[]> currentIsland = new ArrayList<>();
    Set<String> uniqueIslands = new HashSet<>(); // Changed to a Set of Strings
    int[][] grid;
    private boolean[][] seen;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.seen = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                dfs(row, col);

                if (currentIsland.isEmpty()) continue;

                // Normalize the island
                int minRow = grid.length - 1;
                int minCol = grid[0].length - 1;

                for (int[] cell : currentIsland) {
                    minRow = Math.min(minRow, cell[0]);
                    minCol = Math.min(minCol, cell[1]);
                }

                List<int[]> normalizedIsland = new ArrayList<>();
                for (int[] cell : currentIsland) {
                    normalizedIsland.add(new int[]{cell[0] - minRow, cell[1] - minCol});
                }

                // Convert the island to a string representation
                String islandString = islandToString(normalizedIsland);

                uniqueIslands.add(islandString); // Add to the set

                currentIsland = new ArrayList<>();
            }
        }

        return uniqueIslands.size();
    }

    public void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        if (seen[row][col] || grid[row][col] == 0) return;

        seen[row][col] = true;
        currentIsland.add(new int[]{row, col});

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

    // Helper function to convert an island to a string
    private String islandToString(List<int[]> island) {
        StringBuilder sb = new StringBuilder();
        for (int[] cell : island) {
            sb.append(cell[0]).append(",").append(cell[1]).append(";"); // Use a delimiter
        }
        return sb.toString();
    }
}