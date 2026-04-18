class Solution {
    public int largestAltitude(int[] gain) {

        int steep = 0;
        int now = 0;
        
        for(int gai : gain) {
            steep += gai;
            now = Math.max(steep, now);
        }

        return now;
        
    }
}