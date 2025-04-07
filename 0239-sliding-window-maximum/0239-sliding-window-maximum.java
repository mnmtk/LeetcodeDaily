class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dp = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < k ; i ++) {
            while(!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.offerLast(i);
        }
        res.add(nums[dp.peekFirst()]);

        for(int i = k; i < nums.length; i++) {
            if(dp.peekFirst() <= i - k) {
                dp.pollFirst();
            }

             while(!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.offerLast(i);
            res.add(nums[dp.peekFirst()]);

        }
        return res.stream().mapToInt(i->i).toArray();
    }
}