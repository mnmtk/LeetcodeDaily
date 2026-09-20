import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            // Attempt to remove the number. 
            // If false, it was already processed in a previous sequence.
            if (!numSet.remove(num)) {
                continue;
            }

            int currentStreak = 1;

            // Expand rightward and delete
            int right = num + 1;
            while (numSet.remove(right)) {
                currentStreak++;
                right++;
            }

            // Expand leftward and delete
            int left = num - 1;
            while (numSet.remove(left)) {
                currentStreak++;
                left--;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}