class Solution {
public:
    bool dfs(int cx, int cy, vector<vector<char>> &grid, vector<vector<bool>> &visited, int px, int py, int depth) {
        if(visited[cx][cy]) return true;
        vector<vector<int>> dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        visited[cx][cy] = true;

        bool isCycle = false;
        for(int i=0; i<dirs.size(); i++) {
            int dx = cx + dirs[i][0];
            int dy = cy + dirs[i][1];
            if (dx < grid.size() && dy < grid[0].size() && dx >=0 && dy >= 0 && grid[dx][dy] == grid[cx][cy]  && (dx != px || dy != py) ) {
                if (depth >= 4 && visited[dx][dy]) {
                    return true;
                } else if (!visited[dx][dy]){
                    isCycle = isCycle || dfs(dx, dy, grid, visited, cx, cy, depth+1);
                }
            }
        }

        return isCycle;
    }
    bool containsCycle(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool> (m, false));

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, grid, visited, -1, -1, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
};