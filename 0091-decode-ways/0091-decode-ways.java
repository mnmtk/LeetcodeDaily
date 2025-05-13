class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() ==0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1]; // accommodate an empty string
        dp[0] = 1 ; //empty string bnane ka ek i trika hai
        dp[1] = 1; //ek digit ek i trika;

        for(int i = 2; i <= s.length() ; i++) {

            if(s.charAt(i-1)!= '0') {
                dp[i] += dp[i-1];
            }


            String substring = s.substring(i-2, i);
            if(Integer.parseInt(substring) >= 10 && Integer.parseInt(substring)<=26) {
                dp[i] += dp[i-2];
            }

        }

        return dp[s.length()];
    }
}