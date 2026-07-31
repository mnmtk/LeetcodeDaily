class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // Substrings of length 3 or more (diff is length - 1)
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (diff + 1 > maxLen) {
                        start = i;
                        maxLen = diff + 1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}