class Solution {
    int maxLength = 0;
    int start = 0;
    int count = 0;
    public int countSubstrings(String s) {
           if(s == null ) return 0;
        
        for(int i = 0 ;i<s.length();i++) {
            extendPalindrome(s, i, i); //check for odd-length
            extendPalindrome(s, i, i+1); //check fro even length
        }
        return count;
    }

    void extendPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
    }
}