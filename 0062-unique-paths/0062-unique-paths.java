import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        int[] currRow = new int[n];

        // The first row is all 1s because there's only 1 way to move right
        Arrays.fill(prevRow, 1);

        for (int row = 1; row < m; row++) {
            // First cell of any row is always 1 (only 1 path straight down)
            currRow[0] = 1;

            for (int col = 1; col < n; col++) {
                // Current cell = (Value from Above) + (Value from Left)
                currRow[col] = prevRow[col] + currRow[col - 1];
            }

            // Move to the next row: current becomes the new previous!
            prevRow = currRow.clone();
        }

        return prevRow[n - 1];
    }
}