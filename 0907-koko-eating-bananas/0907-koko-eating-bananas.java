class Solution {

    public boolean feasible(int speed, int[] piles, int h) {

        int sum = 0;

        for(int pile : piles) {
            sum += Math.ceil((double)pile / speed); 
        //    sum += (pile + speed - 1) / speed; 
        }

        return sum <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 1;

        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(feasible(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1; 
            }
        }

        return left;
    }
}