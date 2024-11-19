class Solution {
    public int mySqrt(long x) {
        
        long left = 1;
        long right = x + 1;

        while(left < right) {
            long mid = left + (right-left)/2;

            if(mid*mid <= x) {
                left = mid+1;
            } else {
                right = mid;
            }
        } 

        return (int)left - 1;
        
    }
}