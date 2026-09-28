class Solution {
    public int minCost(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            dp[i][n] = arr[i];
            dp[i][n-1] = Math.max(arr[i], arr[n-1]);
        }
        for (int index = n-2; index >= 0; index --) {

            for (int firstIndex = 0; firstIndex < index; firstIndex ++) {
                int path1 = Math.max(arr[firstIndex], arr[index]) 
                + dp[index + 1][index + 2];
                int path2 = Math.max(arr[firstIndex], arr[index + 1]) 
                + dp[index][index + 2];
                int path3 = Math.max(arr[index], arr[index + 1]) 
                + dp[firstIndex][index + 2];
                dp[firstIndex][index] = Math.min(path1, Math.min(path2, path3));
            }
            
        }
        return dp[0][1];
    }

/* refer to this recursive function for understanding the bottom up dp
    private int f(int firstIndex, int index) {
        if (index >= n) {
            return arr[firstIndex];
        }
        if (index == n-1) {
            return Math.max(arr[firstIndex], arr[n-1]);
        }
        int path1 = Math.max(arr[firstIndex], arr[index]) + f(index + 1, index + 2);
        int path2 = Math.max(arr[firstIndex], arr[index + 1]) + f(index, index + 2);
        int path3 = Math.max(arr[index], arr[index + 1]) + f(firstIndex, index + 2);
        return Math.min(path1, Math.min(path2, path3));
    }
    */
}