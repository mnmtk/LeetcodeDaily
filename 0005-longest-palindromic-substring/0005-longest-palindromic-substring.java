class Solution {
    int max = 0;
        int start =0;
    public String longestPalindrome(String s) {
        for(int i = 0; i<s.length();i++) {
            expand(i, i, s); //even
            expand(i, i+1, s);//odd  
        }

        return s.substring(start, start + max);
    }

    public void expand(int p1, int p2, String s) {

        while (p1>=0 && p2< s.length() && s.charAt(p1) == s.charAt(p2)) {
            p1--;
            p2++;
        } 

        int length = p2 - p1 -1;

        if (length > max) {
            max = length;
            start = p1+1;
        }
    }
}