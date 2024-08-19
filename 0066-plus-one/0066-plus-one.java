class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
	    if (digits[i] < 9) {
            digits[i]++;
            return digits;
	    }
	    digits[i] = 0;
        }

        digits = new int[digits.length + 1]; //points to the same memory
        // When you write digits = new int[digits.length + 1];
        // you're creating a completely new array in memory.
        // The digits variable is now updated to reference this new array.
        // This new array has one extra element at the beginning, 
        // which you set to 1 (digits[0] = 1), representing the carryover.
        // The rest of the elements are already 0.
        digits[0] = 1;

        return digits;      
    }
}