class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int eventIndex = 0;
        int totalEvents = 0;
        int maxDay = 0;

        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        for (int day = 1; day <= maxDay; day++) {

            while (eventIndex < events.length && events[eventIndex][0] == day) {
                minHeap.offer(events[eventIndex][1]); 
                eventIndex++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll(); 
                totalEvents++;  
            }
        }

        return totalEvents;
        
    }
}