class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x + 1;

        while(left < right) {
            int mid = left + (right - left)/2;

            if(mid*mid <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
        
    }
}