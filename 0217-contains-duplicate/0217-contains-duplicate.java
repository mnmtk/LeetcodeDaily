class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.add(num) == false) return true;
        }
        
        return false;
    }


            // Arrays.sort(nums);

        // for(int i = 0; i < nums.length - 1; i++) {
        //     if(nums[i] == nums[i+1]) return true;
        // }

        // return false;
}