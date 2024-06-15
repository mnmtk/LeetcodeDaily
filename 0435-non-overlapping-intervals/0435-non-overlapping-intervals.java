class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[1], b[1]));
        int lastEnd = intervals[0][1];
        int min = 1;
        for (int i = 0; i<intervals.length;i++) {

            if(intervals[i][0] >= lastEnd) {
                lastEnd = intervals[i][1];
                min++;
            }
        }

        return intervals.length - min;
    }
}