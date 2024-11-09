class Solution {

    public boolean feasible(int days, int m, int k, int[] bloomDay) {
        int total = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (days >= bloom) {
                flowers++;
                if (flowers == k) {
                    total++;
                    flowers = 0;
                }

                if (total == m) {
                    return true;
                }
            } else {
                flowers = 0;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = 0;
        int right = 0;

        for (int bloom : bloomDay) {
            right = Math.max(bloom, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (feasible(mid, m, k, bloomDay)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
