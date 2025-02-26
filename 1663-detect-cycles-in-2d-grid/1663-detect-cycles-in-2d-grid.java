class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!vis[i][j]){
                    if(dfs(grid,vis,i,j,-1,-1,dr,dc)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] vis, int r, int c, int prevR, int prevC, int[] dr, int[] dc) {
        vis[r][c]=true;

        for(int i=0;i<4;i++){
            int newr = dr[i]+r;
            int newc = dc[i]+c;
            if(newr>=0 && newr<grid.length&&newc>=0&&newc<grid[0].length){

                if(grid[r][c]!=grid[newr][newc])continue;
                if(newr==prevR &&newc==prevC) continue;
                if(vis[newr][newc])return true;
                if(dfs(grid,vis,newr,newc,r,c,dr,dc))return true;
                
                }
            }

        return false;
    }
}