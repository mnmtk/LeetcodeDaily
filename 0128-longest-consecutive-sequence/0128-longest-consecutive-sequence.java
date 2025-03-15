import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        
        // Insert all numbers into the set
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!numSet.contains(num)) {
                continue; // Skip if already counted and removed
            }

            int currentNum = num;
            int currentStreak = 1;
            numSet.remove(currentNum);

            // Expand forward
            while (numSet.contains(currentNum + 1)) {
                numSet.remove(currentNum + 1);
                currentNum++;
                currentStreak++;
            }

            // Expand backward
            currentNum = num;
            while (numSet.contains(currentNum - 1)) {
                numSet.remove(currentNum - 1);
                currentNum--;
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
