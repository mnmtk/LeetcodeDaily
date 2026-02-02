class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < nums.length; i ++) {
            int p1 = i + 1;
            int p2 = nums.length - 1;

            while(p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];

                if(sum == 0) {
                    List<Integer> set = new ArrayList<>();
                    set.add(nums[i]);
                    set.add(nums[p1]);
                    set.add(nums[p2]);

                    ans.add(set);
                    p1++;
                } else if (sum < 0){
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}