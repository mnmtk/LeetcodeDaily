class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 

        PriorityQueue<Integer> pq = new PriorityQueue<>((m, n) -> map.get(m) - map.get(n) );

        for(int key : map.keySet()) {
            pq.offer(key);
            if(pq.size() > k) {
                pq.poll();
            }
        } 
        int[] ans = new int[k];

        for(int i =0; i <k;i++) {
            if(!pq.isEmpty()) {
            ans[i] = pq.poll();
            }
        }
        
        return ans;
    }
}