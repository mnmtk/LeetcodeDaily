class Solution {
    public int mySqrt(long x) {

        int left = 1;
        int right = x + 1;

        while(left < right) {
            int mid = right + (left - right)/2 ;
            if(mid*mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return (int)left -1 ;
    }
}