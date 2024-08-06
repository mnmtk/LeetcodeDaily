class Solution {
   public int missingNumber(int[] nums) {
    int n = nums.length; // Length of the array
    int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
    int actualSum = 0; // Variable to hold the sum of the elements in nums
    
    // Calculate the sum of the elements in the array
    for (int num : nums) {
        actualSum += num;
    }
    
    // The missing number is the difference between expected and actual sum
    return expectedSum - actualSum;
}
}