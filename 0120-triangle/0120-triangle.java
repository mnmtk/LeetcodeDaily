import java.util.List;

class Solution {
    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        if (memo[row][col] != Integer.MIN_VALUE) {
            return memo[row][col];
        }

        int left = dfs(triangle, row + 1, col);
        int right = dfs(triangle, row + 1, col + 1);
        
        memo[row][col] = triangle.get(row).get(col) + Math.min(left, right);
        return memo[row][col];
    }
}
