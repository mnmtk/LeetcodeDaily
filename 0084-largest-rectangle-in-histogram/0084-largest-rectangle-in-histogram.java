import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    
    class Tower {
        int length; 
        int start;

        Tower(int length, int start) {
            this.length = length;
            this.start = start;
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        int ans = 0; 
        
        Deque<Tower> increasingStack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int length = heights[i];
            int start = i; 
            
            while (!increasingStack.isEmpty() && increasingStack.peek().length > length) {
                Tower now = increasingStack.pop();
                
                int end = i; 
                int area = now.length * (end - now.start);
                ans = Math.max(ans, area);
                
                start = now.start; 
            }
            
            increasingStack.push(new Tower(length, start));
        }
        

        while (!increasingStack.isEmpty()) {
            Tower now = increasingStack.pop();
            int end = heights.length; 
            int area = now.length * (end - now.start);
            ans = Math.max(ans, area);
        }
        
        return ans;
    }
}