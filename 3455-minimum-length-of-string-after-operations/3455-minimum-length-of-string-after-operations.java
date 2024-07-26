class Solution {
    public int minimumLength(String s) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
int key = charArr[i] - 'a';
            indexMap.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }

        int ans = 0;

        for (Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            int size = entry.getValue().size();
            if (size % 2 == 0) {
                ans += 2;
            } else  {
                  ans += 1;
            } 
        }

        return ans;
    }
}
