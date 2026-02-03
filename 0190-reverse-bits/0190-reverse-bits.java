class Solution {
    public int reverseBits(int n) {

        // treat n as unsigned value

        int ret = 0;
        int power = 31;

        while( n != 0) {
            ret += (n&1) << power;
            n = n >> 1;
            power -=1;
        }     

        return ret;   
    }
}