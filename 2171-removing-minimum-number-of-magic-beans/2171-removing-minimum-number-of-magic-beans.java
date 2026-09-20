class Solution {
        public long minimumRemoval(int[] beans) {
        long mx = 0, sum = 0;
        Arrays.sort(beans);
        for (int i = 0, n = beans.length; i < n; ++i) {
            sum += beans[i];
            mx = Math.max(mx, (long)beans[i] * (n - i));
        }
        return sum - mx;
    }
}