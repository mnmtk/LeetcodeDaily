class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res = 0;
        while(amount[2] != 0) {
            res++;
            amount[2]--;

            if(amount[1] > 0) {
                amount[1]--;
            }
            Arrays.sort(amount);
        }

        return res;
    }
}