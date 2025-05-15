class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        for(int[] arr:cuboids)
            Arrays.sort(arr);

        Arrays.sort(cuboids,(a,b)->(a[0]*a[1]*a[2]-b[0]*b[1]*b[2]));
        int dp[] = new int[n];
        int ans = cuboids[0][2];
        
        dp[0] = ans;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(cuboids[j][0]<=cuboids[i][0]&&cuboids[j][1]<=cuboids[i][1]&&cuboids[j][2]<=cuboids[i][2]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] = cuboids[i][2]+dp[i];
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}