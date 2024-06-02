class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1,n2) -> map.get(n1) - map.get(n2)
        );

        for(int key : map.keySet()) {
            pq.offer(key);

            if(pq.size() > k) {
                pq.remove();
            }
        }

        int[] ans = new int[k];
        for(int i = 0 ;i<k;i++) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}