class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> seen = new HashMap<>();

        int start = 0;
        int maxLength = 0; 
        
        for(int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            if(seen.get(c)!= null && seen.get(c) >= start) {
                start = seen.get(c) + 1;
            }

            seen.put(c, right);

            int length = right - start + 1;

            maxLength = Math.max(length, maxLength);
        }

        return maxLength;
        
    }
}