class Solution {
    public long shadowPairs(int[] nums) {
        long totalPairs = 0;
        int n = nums.length;

        // Monotonic stack storing elements in non-decreasing order
        int[] stack = new int[n];
        int stackSize = 0;

        for (int num : nums) {
            // 1. Maintain monotonic property: pop elements strictly greater than num
            while (stackSize > 0 && stack[stackSize - 1] > num) {
                stackSize--;
            }

            // 2. Binary search for the first element >= num in the stack
            int left = 0;
            int right = stackSize;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (stack[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 3. Elements at indices [0 ... left - 1] in stack are strictly smaller than num
            totalPairs += left;

            // 4. Push current element onto stack
            stack[stackSize++] = num;
        }

        return totalPairs;
    }
}