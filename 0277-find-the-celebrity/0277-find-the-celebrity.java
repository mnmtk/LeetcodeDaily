public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should not know i and i should know candidate
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}