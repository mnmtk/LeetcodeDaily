class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0; 
        Set set = new HashSet<>(); //sorted set ? space complexity ?

        for(int num : nums) {
            set.add(num);   // //sorted set ? time complexity to add?
        }

        for(int num : nums) {
            int thisMax = 1;
            int prev = num - 1;
            int next = num + 1;
            while(set.remove(prev--)) {
                thisMax++;
            }

            while(set.remove(next++)) {
                thisMax++;
            }

            max = Math.max(thisMax, max);
        }
        
        return max;
    }
}