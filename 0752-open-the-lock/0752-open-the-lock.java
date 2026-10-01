import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        
        // Base case: starting point is blocked
        if (deadSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all combinations at the current level/distance
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                // Generate all 8 neighbor states
                for (String next : getNextStates(current)) {
                    if (!deadSet.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            turns++;
        }

        return -1; // Target unreachable
    }

    // Helper to generate the 8 possible turns from the current lock state
    private List<String> getNextStates(String lock) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = lock.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Turn wheel forward (+1)
            chars[i] = original == '9' ? '0' : (char) (original + 1);
            neighbors.add(new String(chars));

            // Turn wheel backward (-1)
            chars[i] = original == '0' ? '9' : (char) (original - 1);
            neighbors.add(new String(chars));

            chars[i] = original; 
        }

        return neighbors;
    }
}