class Solution {
    int moveCost = 0;
    int pushCost = 0;
    int startCost = 0;

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        this.moveCost = moveCost;
        this.pushCost = pushCost;
        this.startCost = startAt;

        int m = targetSeconds / 60;
        int s = targetSeconds % 60;

        // Calculate costs for both valid time configurations
        int same = find(m, s);
        int one = find(m - 1, s + 60);

        if (s >= 40 || m == 0) return same;
        if (m > 99) return one;

        return Math.min(same, one);
    }

    private int find(int m, int s) {
        // Initialize keysPressed and lastKey
        int[] data = new int[] {0, startCost};
        int ans = 0;

        // Process each digit: tens and units of minutes and seconds
        ans += each(data, m / 10); // Tens place of minutes
        ans += each(data, m % 10); // Units place of minutes
        ans += each(data, s / 10); // Tens place of seconds
        ans += each(data, s % 10); // Units place of seconds

        return ans;
    }

    private int each(int[] data, int currKey) {
        
        data[0] += currKey;
        if (data[0] == 0) return 0; 

        int increment = (data[1] == currKey) ? pushCost : pushCost + moveCost;
        data[1] = currKey;

        return increment;
    }
}
