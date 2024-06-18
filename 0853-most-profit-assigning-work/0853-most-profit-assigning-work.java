class Solution {

   public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        // Combine difficulty and profit into a list of pairs
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // Sort workers
        Arrays.sort(worker);

        int maxProfit = 0, ans = 0, j = 0;
        for (int work : worker) {
            // Update maxProfit as long as the current job's difficulty is <= worker's ability
            while (j < n && work >= jobs[j][0]) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }
            ans += maxProfit;  // Add the best possible profit for this worker
        }

        return ans;
    }
}