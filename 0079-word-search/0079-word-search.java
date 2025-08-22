class Solution {
    int row = 0;
    int col = 0;
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int level, boolean[][] visited) {
      
        if(x < 0 || y < 0 || x >= row || y >= col || level >= word.length() || 
           board[x][y] != word.charAt(level) || visited[x][y]) {
            return false;
        }

        if(level == word.length() - 1) {
            return true;
        }
        
        visited[x][y] = true;

        for(int[] dir : directions) {
            if(dfs(board, x + dir[0], y + dir[1], word, level + 1, visited)) {
                return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}