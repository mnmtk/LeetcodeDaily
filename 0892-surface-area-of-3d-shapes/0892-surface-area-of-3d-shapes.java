class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalSurfaceArea = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                
                int towerHeight = grid[row][col];
                if (towerHeight == 0) continue;

                totalSurfaceArea += 2;

                for (int[] d : directions) {
                    int neighbourRow = row + d[0];
                    int neighbourCol = col + d[1];

                    int neighbourHeight = 0;
                    if (neighbourRow >= 0 && neighbourRow < n
                            && neighbourCol >= 0 && neighbourCol < n) {
                        neighbourHeight = grid[neighbourRow][neighbourCol];
                    }

                    totalSurfaceArea += Math.max(0, towerHeight - neighbourHeight);
                }
            }
        }
        return totalSurfaceArea;
    }
}