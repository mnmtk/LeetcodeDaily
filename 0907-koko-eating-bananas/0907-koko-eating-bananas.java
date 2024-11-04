class Solution {
    public boolean feasible(int speed, int[] piles, int h) {
        int hours = 0;
        for (int pile : piles) {
            //hours += (pile + speed - 1) / speed; // Calculates the ceiling without Math.ceil
            hours += (int) Math.ceil((double) pile / (double)speed);
            if (hours > h) {
                return false;
            }
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (feasible(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
