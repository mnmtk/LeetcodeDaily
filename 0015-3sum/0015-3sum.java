class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); //nlogn list is sorted
        int n = nums.length;

        Set<List<Integer>> ans = new HashSet<>();
      
        for(int i = 0; i < n; i++) { //for every number, 
            int p1=i + 1;
            int p2=n - 1;
            while(p1 < p2) {
                int sum = nums[p1] + nums[p2] + nums[i];

                if(sum == 0) {
                    
                    ArrayList<Integer> sp = new ArrayList<>();
                    sp.add(nums[i]);
                    sp.add(nums[p1]);
                    sp.add(nums[p2]);

                    ans.add(sp);
                    p1++;
                } else if (sum < 0) {
                    p1++;
                } else {
                    p2--;
                }
                
            }
        }

        return new ArrayList<>(ans);
        
    }
}