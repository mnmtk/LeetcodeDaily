class Solution {
    public int maxSubarrayLength(int[] nums) {

        int n = nums.length;

        Stack<int[]> stack = new Stack<>();

        for(int i =0 ;i < nums.length; i++) {
            if(stack.isEmpty() || stack.peek()[0] < nums[i]) {
                stack.add(new int[] {nums[i], i});
            }
        }



        int res = 0;
        for(int i=n-1; i>= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[1] > i) stack.pop();
            int lastIndex = i + 1;

            while(!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                lastIndex = stack.pop()[1];
            }

            res = Math.max(res, i - lastIndex + 1);
        }

        return res;
        
    }
}