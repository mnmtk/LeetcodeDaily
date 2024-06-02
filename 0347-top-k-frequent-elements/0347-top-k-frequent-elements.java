class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2)
        );
        
        for(int key : map.keySet()) {
            minHeap.offer(key);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }

        int[] ans = new int[k];

        for(int i=0; i<k;i++) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}