import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
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
            // 1. Maintain monotonic property by popping strictly greater elements
            while (!stack.isEmpty() && stack.peek().val > num) {
                totalInStack -= stack.pop().count;
            }

            // 2. Calculate strictly smaller elements in O(1)
            long equalCount = (!stack.isEmpty() && stack.peek().val == num) 
                              ? stack.peek().count 
                              : 0;
            
            long smallerCount = totalInStack - equalCount;
            totalPairs += smallerCount;

            // 3. Push new element or increment duplicate frequency
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