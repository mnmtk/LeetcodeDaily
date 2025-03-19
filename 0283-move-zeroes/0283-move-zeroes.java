class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;

        //agge nikluga i ni agar non zero hai same index te game hai sari

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }

        }        
    }
}