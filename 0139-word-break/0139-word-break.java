class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null || s.length() == 0) 
        return false;

        Boolean[] dp = new Boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 0;i<s.length();i++) {
            for(int j = i; j>=0; j--) {

             String sub = s.substring(j, i+1);
             if(dp[j]!= null && dp[j] && wordDict.contains(sub)) {
                System.out.println(sub);
                dp[i+1] = true;
                break;
             }
            }
        }


        return dp[s.length()] != null && dp[s.length()];
        
        
    }
}