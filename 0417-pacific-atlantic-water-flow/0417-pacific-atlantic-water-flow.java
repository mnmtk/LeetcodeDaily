class Solution {
    int rows;
    int cols;

    int[][] dir =  {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] master;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

    if(heights.length == 0 || heights[0].length == 0) return new ArrayList<>();

    master = heights;    

    rows = heights.length;
    cols = heights[0].length;  
      
    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];
    List<List<Integer>> answer = new ArrayList<>();
    
    for(int i = 0; i< rows;i++) {
          dfs(pacific, i, 0, Integer.MIN_VALUE);
          dfs(atlantic, i, cols-1, Integer.MIN_VALUE);
    }

    for(int i=0;i<cols;i++) {
          dfs(pacific, 0, i, Integer.MIN_VALUE);
          dfs(atlantic, rows-1, i, Integer.MIN_VALUE);
    }

    for(int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
        if(pacific[i][j] && atlantic[i][j]) {
            answer.add(Arrays.asList(i,j));
            }
        }
    }

    return answer;
    }

    public void dfs(boolean[][] grid, int i, int j, int current) {
        if(i<0 || j<0 || i>=rows || j>=cols || master[i][j] < current || grid[i][j]) {
            return;
        }
        grid[i][j] = true;
        for (int[] di : dir) {
            dfs(grid, i+di[0], j+di[1], master[i][j]);
        }
    }
}