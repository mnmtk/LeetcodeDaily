class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }


        int count = 0;
        int left = 0;
        int m = t.length();
        int ans = Integer.MAX_VALUE;
        String answer = "";

        Map<Character, Integer> freq2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right<s.length(); right++) {

            char rightChar = s.charAt(right);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            
            if (freq2.containsKey(rightChar) && freq.get(rightChar) <= freq2.get(rightChar)) {
                count++;
            }

            while (count == t.length()) {
                int valid = right - left + 1;
                if(valid < ans) {
                    ans = valid;
                    answer = s.substring(left, right+1);
                }

                char c = s.charAt(left);
                freq.put(c, freq.getOrDefault(c, 0) - 1);

                if(freq.getOrDefault(c, 0) < freq2.getOrDefault(c, 0)) {
                    count--;
                }
                left++;
            }
        }

        return answer;
        
    }
}