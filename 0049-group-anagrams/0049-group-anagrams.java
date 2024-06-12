import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            String key = createKey(str);
            List<String> currentLists = map.getOrDefault(key, new ArrayList<>());
            currentLists.add(str);  // Corrected this line to add the original string
            map.put(key, currentLists);
        }

        for (String entry : map.keySet()) {
            result.add(map.get(entry));
        }
        return result;
    }

    String createKey(String str) {
        char[] key = str.toCharArray();
        Arrays.sort(key);
        return new String(key);
    }

   
}
