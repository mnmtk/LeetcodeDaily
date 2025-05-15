class Solution {
    Integer memo[][];

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return minDistanceRecur(word1, word2, word1.length(), word2.length());
    }

    private int minDistanceRecur(String word1, String word2, int i, int j) {
        // If word1 is empty, insert all characters of word2
        if (i == 0) {
            return j;
        }
        // If word2 is empty, delete all characters of word1
        if (j == 0) {
            return i;
        }
        // Return cached result if already computed
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            // Characters match, no operation needed
            memo[i][j] = minDistanceRecur(word1, word2, i - 1, j - 1);
        } else {
            // Characters don't match, try insert, delete, replace
            int insertOp = minDistanceRecur(word1, word2, i, j - 1);
            int deleteOp = minDistanceRecur(word1, word2, i - 1, j);
            int replaceOp = minDistanceRecur(word1, word2, i - 1, j - 1);

            memo[i][j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
        }
        return memo[i][j];
    }
}
