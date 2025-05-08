class Solution {

    int[][] rects;
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        for (int[] x : rects) {
            tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
            psum.add(tot);
        }
    }

    public int[] pick() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = rects.length - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid))
                lo = mid + 1;
            else
                hi = mid;
        }

        int[] x = rects[lo];
        int width = x[2] - x[0] + 1;
        int height = x[3] - x[1] + 1;
        int base;

        if (lo == 0) {
            base = psum.get(lo) - width * height;
        } else {
            base = psum.get(lo - 1);
        }

        return new int[] { x[0] + (targ - base) % width, x[1] + (targ - base) / width };

        //When converting a 1D offset to 2D coordinates:

        // The column (x) is found with offset % width (modulus by number of columns).
        // The row (y) is found with offset / width (integer division by number of columns)

        /*
        For a given offset:
        The X-coordinate (column) is:
        x0 + (offset mod width)

        This moves you horizontally across the grid. Each time the offset increases by 1, you move to the next column. 
        When you reach the end of a row (i.e., offset % width = 0), you wrap to the next row.
        
        The Y-coordinate (row) is:
        y0+(offset÷width)
        This moves you vertically. Each time you complete a row (i.e., after width increments), you move down to the next row.*/
    }
}