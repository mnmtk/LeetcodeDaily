class Solution {
    public double helper(double line, int[][] squares) {
        double aAbove = 0;
        double aBelow = 0;

        for(int i = 0; i < squares.length; i++) {

            int x = squares[i][0],
                y = squares[i][1],
                l = squares[i][2];

            double total = (double) l * l;

            if(line <= y) {

                aAbove += total;
            } else if(line >= y + l) {
                
                aBelow += total;
            } else {

                double aboveHeight = (y + l) - line;
                double belowHeight = line - y;

                aAbove += l * aboveHeight;
                aBelow += l * belowHeight;
            }
        }

        return aAbove - aBelow;
    }

    public double separateSquares(int[][] squares) {
        double lo = 0; 
        double hi = 2*1e9;

        for (int i = 0; i < 60; i++) {
            double mid = (lo + hi)/ 2.0;
            double diff = helper(mid, squares);

            if(diff > 0) 
                lo = mid;
            else 
                hi = mid;
        }

        return hi;
    }
}