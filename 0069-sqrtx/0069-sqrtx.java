class Solution {
    public int mySqrt(int x) {

        int left = 1;
        int right = x;

        while(left < right) {
            int mid = right + (left - right)/2 ;
            if(mid*mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left -1 ;
    }
}