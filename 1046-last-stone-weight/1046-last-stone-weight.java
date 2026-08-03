class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int stone: stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }

        return pq.poll();
        
    }
}