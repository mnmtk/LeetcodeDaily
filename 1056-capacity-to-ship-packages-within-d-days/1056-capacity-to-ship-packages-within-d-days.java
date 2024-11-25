class Solution {

    public boolean feasible(int capacity, int[] weights, int days) {

        int curr = 0;
        int dayCount = 1;

        for(int wt : weights) {

            curr+=wt;
            
            if(curr > capacity) {
                curr = wt;
                dayCount++;

                if(dayCount > days) {
                    return false;
                }
            }


        }


        return true;

    }

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 1;

      for(int weight : weights) {
            right +=weight;
            left = Math.max(weight, left);
        }

        while (left < right) {
            int mid = left + (right - left)/2;
            if(feasible(mid, weights, days)) {
                right = mid;

            } else {

                left = mid+1;
            }
        }

        return left ;
        
    }
}