class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> minPq =  new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int maxLength = 1;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            minPq.offer(new int[] {nums[right], right});
            maxPq.offer(new int[] {nums[right], right});

            while(maxPq.peek()[0] - minPq.peek()[0] > limit) {

                left = Math.min(minPq.peek()[1], maxPq.peek()[1]) + 1;
                while(minPq.peek()[1] < left) {
                    minPq.poll();
                }

                while(maxPq.peek()[1] < left) {
                    maxPq.poll();
                }
            }


                maxLength = Math.max(maxLength, right - left + 1);

        }


        return maxLength;
        
    }
}