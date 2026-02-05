class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
           

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                     if (end == s.length()) {
                return true;
            }
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }
}