class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // FIX 2: Prevent infinite loop if the starting pixel is already the target color
        if (image[sr][sc] == color) {
            return image; 
        }

        dfs(color, sr, sc, image[sr][sc], image);

        return image;
    }

    public void dfs(int color, int sr, int sc, int prev, int[][] image) {
        // FIX 1: Corrected row and column boundary checks
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }

        // Only color and recurse if the current cell matches the original starting color
        if(image[sr][sc] == prev) {
            image[sr][sc] = color;
        } else {
            return;
        }

        // Check all 4 directions
        for(int[] d : dir) {
            dfs(color, sr + d[0], sc + d[1], prev, image);
        }
    }
}