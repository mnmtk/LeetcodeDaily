import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        // Step 1: Sort words by their length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // Map to store word -> longest chain length ending at this word
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1;
        
        for (String word : words) {
            int currentBest = 1; // Base case: chain containing just this word
            
            // Step 2: Try removing every character to form potential predecessors
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                
                // If the predecessor exists in our map, extend its chain
                if (dp.containsKey(predecessor)) {
                    currentBest = Math.max(currentBest, dp.get(predecessor) + 1);
                }
            }
            
            // Save the best chain length for this word
            dp.put(word, currentBest);
            maxLength = Math.max(maxLength, currentBest);
        }
        
        return maxLength;
    }
}