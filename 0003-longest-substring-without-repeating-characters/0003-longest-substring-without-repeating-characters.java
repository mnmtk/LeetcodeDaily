class Solution {
    public int lengthOfLongestSubstring(String s) {

        int res = 0;

        int right = 0;
        int left = 0;

        Map<Character, Integer> seen = new HashMap<>(); //frequencymap
        while(right < s.length()) {

            char current = s.charAt(right);

            seen.put(current, seen.getOrDefault(current, 0) + 1);

            while(seen.get(current) > 1) {
                char l = s.charAt(left); 
                seen.put(l, seen.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;

        }

        return res;
        
    }
}