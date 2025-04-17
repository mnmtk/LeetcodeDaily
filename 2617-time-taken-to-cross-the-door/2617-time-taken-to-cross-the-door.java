import java.util.*;

class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] ans = new int[n];
        
        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();
        
        int time = 0;
        int i = 0; // index to track arrivals
        int lastUsed = 1; // 1 means last used for exit or unused, 0 means last used for enter
        
        while (i < n || !enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            // Add all people who have arrived by current time to their respective queues

            while (i < n && arrival[i] <= time) {

                if (state[i] == 0) {
                    enterQueue.offer(i);
                } else {
                    exitQueue.offer(i);
                }
                
                i++;
            }
            
            if (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {
                // Both queues have people, decide based on lastUsed
                if (lastUsed == 1) {
                    // Last used for exit or unused, exit goes first
                    int idx = exitQueue.poll();
                    ans[idx] = time;
                    lastUsed = 1;
                } else {
                    // Last used for enter, enter goes first
                    int idx = enterQueue.poll();
                    ans[idx] = time;
                    lastUsed = 0;
                }
                time++;
            } else if (!enterQueue.isEmpty()) {
                // Only enter queue has people
                int idx = enterQueue.poll();
                ans[idx] = time;
                lastUsed = 0;
                time++;
            } else if (!exitQueue.isEmpty()) {
                // Only exit queue has people
                int idx = exitQueue.poll();
                ans[idx] = time;
                lastUsed = 1;
                time++;
            } else {
                // No one is waiting,
                // increment time and reset lastUsed to 1 (door unused).
                lastUsed = 1;
                time++;
            }
        }
        
        return ans;
    }
}
