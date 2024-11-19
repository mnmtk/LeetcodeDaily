class Solution {
    public int mySqrt(long x) {

        long left = 1;
        long right = x + 1;

        while(left < right) {
            long mid = right + (left - right)/2 ;
            if(mid*mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return (int)left -1 ;
    }
}