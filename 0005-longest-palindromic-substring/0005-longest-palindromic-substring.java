class Solution {
    int max = 0;
    int start = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);   // odd length palindromes
            expand(s, i, i + 1); // even length palindromes
        }
        return s.substring(start, start + max);
    }

    void expand(String s, int p1, int p2) {

        while (p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)) {
            p1--;
            p2++;
        }
        int length = p2 - p1 - 1;
        
        if (length > max) {
            max = length;
            start = p1 + 1; 
        }
    }
}
