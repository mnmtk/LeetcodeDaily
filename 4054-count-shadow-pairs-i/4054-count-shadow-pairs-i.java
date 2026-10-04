import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // Helper class to store value and its frequency
    private static class Node {
        int val;
        int count;
        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public long shadowPairs(int[] nums) {
        long totalPairs = 0;
        Deque<Node> stack = new ArrayDeque<>();
        long totalInStack = 0;

        for (int num : nums) {
            // 1. Pop elements strictly greater than num
            while (!stack.isEmpty() && stack.peek().val > num) {
                totalInStack -= stack.pop().count;
            }

            // 2. Count elements strictly smaller in O(1)
            long equalCount = (!stack.isEmpty() && stack.peek().val == num) 
                              ? stack.peek().count 
                              : 0;
            
            totalPairs += (totalInStack - equalCount);

            // 3. Push or update frequency
            if (!stack.isEmpty() && stack.peek().val == num) {
                stack.peek().count++;
            } else {
                stack.push(new Node(num, 1));
            }
            totalInStack++;
        }

        return totalPairs;
    }
}