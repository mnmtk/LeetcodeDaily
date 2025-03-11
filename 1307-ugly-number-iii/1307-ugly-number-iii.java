class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE;
        
        int ab = lcm(a, b);
        int bc = lcm(b, c);
        int ca = lcm(c, a);
        int abc = lcm(a, bc);

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = mid / a + mid / b + mid / c 
                      - mid / ab - mid / bc - mid / ca 
                      + mid / abc;

            if (count >= n) {
                high = mid; // Similar to Python's logic
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    private int lcm(int x, int y) {
        try {
            int gcdValue = gcd(x, y);
            return Math.multiplyExact(x / gcdValue, y); 
        } catch (ArithmeticException e) {
            return Integer.MAX_VALUE;
        }
    }
}
