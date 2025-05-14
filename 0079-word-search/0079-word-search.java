class Solution {
    int row = 0;
    int col = 0;
    public boolean exist(char[][] board, String word) {
    row = board.length;
    col = board[0].length;

    boolean[][] visited = new boolean[row][col];

    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++) {
            if(dfs(i, j, 0, word, board, visited)) {
                return true;
            }
        }
    }

    return false;    
    }


    boolean dfs(int i, int j, int charIndex, String word, char[][] board, boolean[][] visited) {
        if(word.length() == charIndex) {
            return true;
        }

        if(i < 0 || i >= row || j<0 || j>=col || visited[i][j]|| board[i][j]!=word.charAt(charIndex)) {
        return false;
        }

         visited[i][j] = true;
          boolean foundIt =   
            dfs(i+1, j, charIndex+1, word, board  ,visited) ||
            dfs(i - 1, j, charIndex+1, word,board,visited) ||
            dfs(i, j + 1, charIndex+1, word, board, visited) ||
            dfs(i, j -1, charIndex+1, word,board,  visited);


        visited[i][j] = false;

        return foundIt;
    }
} 