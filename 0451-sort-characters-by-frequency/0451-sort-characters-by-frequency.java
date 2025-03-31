class Solution {
    public String frequencySort(String s) {
        if(s == null || s.isEmpty()) return s;

        Map<Character, Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int maximumFrequency = Collections.max(counts.values());


        List<List<Character>> buckets = new ArrayList<>();

        for(int i = 0 ; i <= maximumFrequency;i++) {
            buckets.add(new ArrayList<>());
        }

        for(Character key : counts.keySet()) {
        int freq = counts.get(key);
        buckets.get(freq).add(key);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = buckets.size() - 1; i>= 1; i--) {
            for(Character c: buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                sb.append(c);
            }
            }
        }

        return sb.toString();

        
    }
}