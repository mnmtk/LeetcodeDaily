class Solution {
    public int numberOfPatterns(int m, int n) {

        int[][] jump = new int[10][10];

        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[1][9] = jump[9][1] = 5;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[3][7] = jump[7][3] = 5;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;

        int totalCount = 0;
        boolean[] visited = new boolean[10];


        totalCount += countPatterns(1, 1, m, n, jump, visited) * 4;
        totalCount += countPatterns(4, 1, m, n, jump, visited) * 4;
        totalCount += countPatterns(5, 1, m, n, jump, visited);

        return totalCount;
    }


    public int countPatterns(
        int currentNumber,
        int currentLength,
        int min,
        int max,
        int[][] jump,
        boolean[] visited
        ) {

            if(currentLength > max) {
                return 0;
            }

          
            int validPatterns = 0;

            if(currentLength >= min) {
                validPatterns++;
            }
              visited[currentNumber] = true;
            for(int nextNumber = 1; nextNumber <= 9; nextNumber ++) {
                int currJump = jump[currentNumber][nextNumber];

                if(!visited[nextNumber] && (currJump == 0 || visited[currJump])) {
                    validPatterns+= countPatterns(
                        nextNumber,
                        currentLength + 1,
                        min,
                        max,
                        jump,
                        visited
                    );
                }
            }


            visited[currentNumber] = false;

            return validPatterns;

        }



}