class Solution {
    public String minimumString(String a, String b, String c) {
        String[] arr = { a, b, c };
        String result = "";

        // All 6 permutations of indices (0, 1, 2)
        int[][] permutations = {
                { 0, 1, 2 }, { 0, 2, 1 },
                { 1, 0, 2 }, { 1, 2, 0 },
                { 2, 0, 1 }, { 2, 1, 0 }
        };

        for (int[] p : permutations) {
            String combined = merge(merge(arr[p[0]], arr[p[1]]), arr[p[2]]);

            if (result.isEmpty() || isBetter(combined, result)) {
                result = combined;
            }
        }

        return result;
    }

    // Merges s2 into s1 with maximum overlap
    private String merge(String s1, String s2) {
        if (s1.contains(s2)) {
            return s1;
        }

        int len1 = s1.length();
        int len2 = s2.length();

        // Find the maximum overlapping length where suffix of s1 matches prefix of s2
        for (int len = Math.min(len1, len2); len > 0; len--) {
            if (s1.endsWith(s2.substring(0, len))) {
                return s1 + s2.substring(len);
            }
        }

        return s1 + s2;
    }

    // Compares candidate string with current best result
    private boolean isBetter(String candidate, String currentBest) {
        if (candidate.length() != currentBest.length()) {
            return candidate.length() < currentBest.length();
        }
        return candidate.compareTo(currentBest) < 0;
    }
}