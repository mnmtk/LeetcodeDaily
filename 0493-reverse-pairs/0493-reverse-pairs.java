class Solution {
    public int reversePairs(int[] nums) {
        int ans = 0 , n = nums.length;
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(nums[i]);
        }
		
        Collections.sort(list);
		
        for(int i = 0; i < n; i++){
		
            int start = 0 , end = list.size() -1;
			// find nums[i] in list and remove from list using binary search in log(n) time .

            while(start <= end) {
                int mid = start + (end - start)/2;
                if(nums[i]  == list.get(mid)){
                    list.remove(mid);
                    break;
                } else if(nums[i] < list.get(mid)) end = mid - 1;
                else start = mid + 1;
            }
			
			// here  using one more times binary search for finding atmost index
			//to correct for reverse condition(given in question) in log(n) time .
			
            start = 0; end = list.size() - 1;
            int val = 0;

            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[i] > (long)2*list.get(mid)){
                    if((mid + 1) > val) val = mid + 1; // add atmost index in ans + 1
                    start = mid + 1;
                }
                else end = mid - 1;
            }
			
            ans += val;
        }

        return ans;
    }
}