class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        
        for(int key : freq.keySet()) {
            pq.offer(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        int i = 0;
        while(i < k) {
            ans[i] = pq.poll();
            i++;
        }

        return ans;

    }
}