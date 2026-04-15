class Solution {
    public boolean isSubsequence(String s, String t) {
        // Handle empty s case
        if (s.isEmpty()) return true;
        
        int sPointer = 0;
        int tPointer = 0;

        // Iterate through string t
        while (tPointer < t.length()) {
            // If characters match, move the pointer for s
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            
            // If we've matched all characters in s, we're done!
            if (sPointer == s.length()) {
                return true;
            }
            
            // Always move the pointer for t
            tPointer++;
        }

        return sPointer == s.length();
    }
}