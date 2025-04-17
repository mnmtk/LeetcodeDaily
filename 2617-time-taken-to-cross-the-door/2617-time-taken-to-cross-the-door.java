class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] ans = new int[n];
        
        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();
        
        int time = 0;
        int i = 0; 
        int lastUsed = 1; 
        
        while (i < n || !enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            while (i < n && arrival[i] <= time) {
                if (state[i] == 0) {
                    enterQueue.offer(i);
                } else {
                    exitQueue.offer(i);
                }
                i++;
            }
            
            if (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {
                if (lastUsed == 1) {
                    int idx = exitQueue.poll();
                    ans[idx] = time;
                    lastUsed = 1;
                } else {
                    int idx = enterQueue.poll();
                    ans[idx] = time;
                    lastUsed = 0;
                }
                time++;
            } else if (!enterQueue.isEmpty()) {
                int idx = enterQueue.poll();
                ans[idx] = time;
                lastUsed = 0;
                time++;
            } else if (!exitQueue.isEmpty()) {
                int idx = exitQueue.poll();
                ans[idx] = time;
                lastUsed = 1;
                time++;
            } else {
                lastUsed = 1;
                time++;
            }
        }
        
        return ans;
    }
}
