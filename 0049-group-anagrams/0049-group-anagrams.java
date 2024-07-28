class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = generateKey(str);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        }

        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }

    public String generateKey(String str) {
        char[] key = str.toCharArray();
        Arrays.sort(key);
        return new String(key);
    }
}