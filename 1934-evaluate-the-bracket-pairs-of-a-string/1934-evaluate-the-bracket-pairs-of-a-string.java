import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Create a map to store key-value pairs from the knowledge base
        Map<String, String> keyValue = new HashMap<>();
        
        // Populate the map with key-value pairs
        for (List<String> know : knowledge) {
            keyValue.put(know.get(0), know.get(1));
        }

        // Initialize variables to track the start and end indices of placeholders
        int replaceStart = 0;
        int replaceEnd = 0;

        // List to store the start and end indices of placeholders
        List<int[]> replaceKeys = new ArrayList<>();

        // Iterate through the string to find placeholders
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                replaceStart = i;
            }
            if (s.charAt(i) == ')') {
                replaceEnd = i;

                // Store the start and end indices of the current placeholder
                replaceKeys.add(new int[] {replaceStart, replaceEnd});
        
            }
        }

        // Call the replace method to replace placeholders with actual values
        return replace(replaceKeys, keyValue, s);
    }

    public String replace(List<int[]> replaceKeys, Map<String, String> keyValue, String s) {
       
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int[] keyIndices : replaceKeys) {
            
            result.append(s.substring(index, keyIndices[0]));
            
            String key = s.substring(keyIndices[0] + 1, keyIndices[1]);


            if (keyValue.containsKey(key)) {
                result.append(keyValue.get(key));
            } else {      
                result.append('?');
            }

            index = keyIndices[1] + 1;
        }

        result.append(s.substring(index));

        return result.toString();
    }
}
