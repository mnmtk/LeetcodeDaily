class Solution {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        Stack<Integer> indicesStack = new Stack<>();

        indicesStack.push(0);

        for(int i = 1; i < n; i++) {
            if(nums[i] <= nums[indicesStack.peek()]) indicesStack.push(i);
        }

    

        int maxWidth = 0;
        for(int i = n - 1; i >= 0; i--) {
           
            while(!indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - indicesStack.peek());
                indicesStack.pop();
            }
            
        }
        

      
        
        return maxWidth;
    }
}