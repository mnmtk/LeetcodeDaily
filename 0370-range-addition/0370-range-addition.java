class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            diff[start] += inc;
            
            if (end + 1 < length) {
                diff[end + 1] -= inc;
            }
        }


        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }
}
