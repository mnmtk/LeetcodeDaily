class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // i, j, cost
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        
        queue.add(new int[]{0,0,health - grid.get(0).get(0)});
        if (health - grid.get(0).get(0) <= 0) {
            return false;
        }
        int[][] max = new int[grid.size()][grid.get(0).size()];
        max[0][0] = grid.get(0).get(0);
        for (int[] row : max) Arrays.fill(row, Integer.MIN_VALUE);
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int i = data[0];
            int j = data[1];
            if (i == grid.size() - 1 && j == grid.get(i).size()-1) {
                return true;
            }
            int h = data[2];
            for (int[] dir : dirs) {
                int newI = dir[0] + i;
                int newJ = dir[1] + j;
                if (newI < 0 || newJ < 0 || newI >= grid.size() || newJ >= grid.get(i).size()) {
                    continue;
                }
                int newCost = h - grid.get(newI).get(newJ);
                
                if (newCost >= 1 && newCost > max[newI][newJ]) {
                    max[newI][newJ] = newCost;
                    queue.add(new int[]{newI, newJ, newCost});
                }
            }
        }
        return false;
        
        
    }
    
}