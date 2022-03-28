class Solution {
    int ans = 0;
    public int helper(int [][]obs, int i, int j, boolean[][] vis, int [][]dir, int[][]dp){
        int n = obs.length, m = obs[0].length;
        if(i == n - 1 && j == m - 1) {
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];    
        }
        vis[i][j] = true;
        int val = 0;
        for(int a = 0; a < 2; a++){
            int ni = dir[a][0] + i;
            int nj = dir[a][1] + j;
            
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && vis[ni][nj] == false && obs[ni][nj] != 1){
                val += helper(obs, ni, nj, vis, dir, dp);
            }
        }
        vis[i][j] = false;
        dp[i][j] = val;
        return val;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(n == 1 && m == 1) return obstacleGrid[0][0] != 1 ? 1 : 0;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;
        boolean [][]vis = new boolean[n][m];
        int dir[][] = {{0,1},{1,0}};
        int [][]dp = new int[n][m];
        return helper(obstacleGrid, 0, 0, vis, dir, dp);
    }
}