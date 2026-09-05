class Solution {
    public int shareCandies(int[] candies, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int c : candies) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int flavours = map.size();          // distinct flavours = number of keys

        if (k == 0) return flavours;        // give nothing away, keep everything

        int ans = 0;
        int left = 0;
        int runningFlavours = 0;            // flavours whose whole population is in the window
        Map<Integer, Integer> runningMap = new HashMap<>();

        for (int right = 0; right < candies.length; right++) {
            int c = candies[right];
            int inWin = runningMap.getOrDefault(c, 0) + 1;
            runningMap.put(c, inWin);
            if (inWin == map.get(c)) {      // whole flavour now inside the gift
                runningFlavours++;
            }

            if (right - left + 1 > k) {     // window too big -> slide left edge out
                int lc = candies[left];
                int lcCount = runningMap.get(lc);   // always present: it's in the window
                if (lcCount == map.get(lc)) {
                    runningFlavours--;      // it's leaving, so this flavour comes back
                }
                runningMap.put(lc, lcCount - 1);
                left++;
            }

            if (right - left + 1 == k) {
                ans = Math.max(ans, flavours - runningFlavours);
            }
        }

        return ans;
    }
}