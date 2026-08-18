public class Solution {
    public boolean isPalindrome(int x) {

        int num = x;
        
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > 0) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }
        return num == revertedNumber;
    }
}