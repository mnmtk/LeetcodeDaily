class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int num : nums) {
            int find = target - num;
            if(map.containsKey(find)) {
                return new int[] {i, map.get(find)};
            }
            map.put(num, i);
            i++;
        }

        return new int[] {-1, -1 };
        
    }
}