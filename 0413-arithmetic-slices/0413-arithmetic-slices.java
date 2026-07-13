public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int total = 0, cur = 0;      // cur = f(i-1)
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                cur++;               // f(i) = f(i-1) + 1
            } else {
                cur = 0;             // f(i) = 0
            }
            total += cur;
        }
        return total;
    }
}