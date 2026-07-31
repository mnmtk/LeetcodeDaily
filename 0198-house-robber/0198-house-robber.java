class Solution {
    public int rob(int[] nums) {
        int rob1 = 0; // Best total robbed up to house (i - 2)
        int rob2 = 0; // Best total robbed up to house (i - 1)

        for (int num : nums) {
            // Choice: rob current house (num + rob1) OR skip current house (rob2)
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}