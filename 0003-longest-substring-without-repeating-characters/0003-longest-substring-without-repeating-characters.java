class Solution {
     public int lengthOfLongestSubstring(String s) {
        // Create a dictionary to store characters and their indices
        Map<Character, Integer> charIndex = new HashMap<>();
        
        // Initialize variables for the sliding window
        int start = 0;
        int maxLength = 0;
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character is already in the dictionary and its index is greater than the start of the current window
            if (charIndex.containsKey(c) && charIndex.get(c) >= start) {
                // Update the start of the window to the index after the previous occurrence of the character
                start = charIndex.get(c) + 1;
            }
            
            // Update the character's index in the dictionary
            charIndex.put(c, i);
            
            // Calculate the length of the current substring
            int currentLength = i - start + 1;
            
            // Update the maximum length if necessary
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}