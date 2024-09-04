class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            int thisMax = 1;
            int prev = num -1;
            int next = num+1;

            while(set.remove(prev--)) {
                thisMax++;
            }

            while(set.remove(next++)) {
                thisMax++;
            }


            max = Math.max(max, thisMax);
            
        }

        return max;
        
    }
}