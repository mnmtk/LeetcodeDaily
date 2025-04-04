public class Solution {
    public int findNthDigit(int n) {
        int numsInOom = 9;    // Numbers in current order of magnitude (1-digit, 2-digit, etc.)
        int digitsInOom = 1;   // Number of digits in each number of this OOM
        
        // Step 1: Find the order of magnitude where the nth digit resides
        while (n > (long) numsInOom * digitsInOom) {
            n -= numsInOom * digitsInOom;
            numsInOom *= 10;
            digitsInOom++;
        }
        
        // Step 2: Find the specific number and the digit within it
        int numberInOom = (n - 1) / digitsInOom;  // Index of the number in the OOM
        int digitInNum = (n - 1) % digitsInOom;    // Index of the digit in the number
        
        // Construct the actual number
        int number = numberInOom + (int) Math.pow(10, digitsInOom - 1);
        
        // Extract and return the nth digit
        return Character.getNumericValue(Integer.toString(number).charAt(digitInNum));
    }
}