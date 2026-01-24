class Solution {
    public int[] twoSum(int[] nums, int target) {
        //brute force -> try all combos.
        //TC: O(n^2) why -> for each you ll see whole array

        //option 2 -> once you see you store what was seen.


        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for(int num : nums) {
            int find = target - num;
            if(map.containsKey(find)) {
                return new int[] {index, map.get(find)};
            }

            map.put(num, index);
            index++;
        }

        return new int[] {-1, -1};
    }
}