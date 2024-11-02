class Solution {
    int D = 0;
    public boolean isPossible(int[] weights, int capacity) {

        int total = 0;
        int day = 1;
        for(int weight : weights) {
            total += weight;

            if(capacity < total) {
                total = weight;
                day++;
                if(day > D) return false;
            }
        }

        return true;

    }

    public int shipWithinDays(int[] weights, int days) {

        D = days;
        int left = 0;
        int right = 0;

        for(int weight : weights) {
            right +=weight;
            left = Math.max(weight, left);
        }

        while(left < right) {
            int mid = left + (right - left)/2;

            if(isPossible(weights, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
        
    }
}