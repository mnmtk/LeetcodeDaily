class Solution {
    // brute force O(n^3) very high  -10^5 <= x <= 10^5 ?
    // 
    public int maxSubArray(int[] nums) {

        int currSum = 0;
        int maxSum = 0;

        for(int num : nums) {

            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(currSum, maxSum);
        }



        return maxSum;
    }
}