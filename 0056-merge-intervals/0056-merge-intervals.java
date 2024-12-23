class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> arrays = new ArrayList<>();

        for(int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];

            if(arrays.isEmpty() || arrays.get(arrays.size() - 1)[1] < currStart) {
                arrays.add(interval);
            } else {
                int[] last = arrays.get(arrays.size() - 1);
                last[1] = Math.max(last[1], currEnd);
            }
        }

        return arrays.toArray(new int[arrays.size()][2]);

    }
}