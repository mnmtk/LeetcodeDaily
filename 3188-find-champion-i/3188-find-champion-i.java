class Solution {
    public int findChampion(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {

            boolean champ = true;
            for(int j=0; j<grid[0].length; j++) {
                if(i == j) continue;
                if(grid[i][j] == 0) {
                    champ = false;
                    break;
                }
            }
            if(champ) return i;
        }
        
        return -1;
    }
}