class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> seen = new HashMap<>();

        int l=0;
        int longest = 0;
        for(int i =0 ;i<s.length();i++) {
            if(seen.get(s.charAt(i)) != null && seen.get(s.charAt(i)) >= l) {
               l = seen.get(s.charAt(i)) + 1;
            } 
            int count = i - l + 1;
            if(count > longest) longest = count;
            seen.put(s.charAt(i), i);
           
        }
        return longest;
    }
}