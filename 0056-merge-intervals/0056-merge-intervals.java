class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int []> ans = new ArrayList<>();

        for(int [] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];

            if(ans.isEmpty() || ans.get(ans.size() -1)[1] < currStart) {
                ans.add(interval);
            } else {
                int[] last = ans.get(ans.size() - 1);
                last[1] = Math.max(last[1], currEnd);
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}