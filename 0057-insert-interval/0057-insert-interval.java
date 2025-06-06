class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;

        ArrayList<int []> ans = new ArrayList<>();

        for(int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];

            if(currStart > end  ||  start > currEnd) {
                if(!inserted && start < currStart) {
                    inserted = true;
                    ans.add(new int[]{start, end});
                }
                ans.add(interval);
            } else {
                start = Math.min(start, currStart);
                end = Math.max(end, currEnd);
            }
        }

        if(!inserted) {
            ans.add(new int[]{start,end});
        }

        return ans.toArray(new int[ans.size()][2]);
        
    }
}