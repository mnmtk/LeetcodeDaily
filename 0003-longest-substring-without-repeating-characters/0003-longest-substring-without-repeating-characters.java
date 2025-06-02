class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s == null) {
            return 0;
        }

        Map<Character, Integer> seen = new HashMap<>();

        int left = 0;
        int max = Integer.MIN_VALUE;

        for(int right = 0; right < s.length() ; right++) {

            char c = s.charAt(right);
            if(seen.get(c)!= null && seen.get(c) >= left) {
               left = seen.get(c) + 1;
            }
              seen.put(s.charAt(right), right);

              max = Math.max(right - left +1, max);

        }

        return max;
        
    }
}