class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int ans = 0; 

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);    

            max = Math.max(max, map.getOrDefault(c, 0));        
            while(max + k < right - start + 1) {
                char startC = s.charAt(start);
                int freq = map.get(startC)-1;
                map.put(startC, freq);
                start++;
            }

            int replacement = right - start + 1;

            ans = Math.max(replacement, ans);

        }
        return ans;
    }
}