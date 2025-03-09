class Solution {
    private static final int[][] directions = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public int regionsBySlashes(String[] grid) {

        int gridSize = grid.length;

        int[][] expandedGrid = new int[gridSize * 3][gridSize*3];

        for(int i = 0 ; i < gridSize; i++) {
            for(int j = 0 ; j < gridSize; j++) {
                int baseRow = i*3;
                int baseCol = j*3;

                if(grid[i].charAt(j) == '\\') {
                    expandedGrid[baseRow][baseCol] = 1;
                    expandedGrid[baseRow + 1][baseCol +1] = 1;
                    expandedGrid[baseRow + 2][baseCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    
                    expandedGrid[baseRow][baseCol + 2] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol] = 1;
                }
            }
        }

        int regionCount = 0;
        for(int i = 0; i < gridSize * 3; i++) {
            for(int j = 0 ; j < gridSize * 3; j++) {
                if(expandedGrid[i][j] == 0) {
                   floodFill(expandedGrid, i, j, 2);
                    regionCount++;
                }
            }
        }


        return regionCount;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                dfs(image, r - 1, c, color, newColor);
            }
            if (c >= 1) {
                dfs(image, r, c - 1, color, newColor);
            }
            if (r + 1 < image.length) {
                dfs(image, r + 1, c, color, newColor);
            }
            if (c + 1 < image[0].length) {
                dfs(image, r, c + 1, color, newColor);
            }
        }
    }
}