class Solution {
    int ans = 0;
    public void helper(int [][]obs, int i, int j, boolean[][] vis, int [][]dir){
        int n = obs.length, m = obs[0].length;
        if(i == n - 1 && j == m - 1) {
            ans++;
            return;
        }
        
        vis[i][j] = true;
        for(int a = 0; a < 2; a++){
            int ni = dir[a][0] + i;
            int nj = dir[a][1] + j;
            
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && vis[ni][nj] == false && obs[ni][nj] != 1){
                helper(obs, ni, nj, vis, dir);
            }
        }
        vis[i][j] = false;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(n == 1 && m == 1) return obstacleGrid[0][0] != 1 ? 1 : 0;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;
        // boolean [][]vis = new boolean[n][m];
        // int dir[][] = {{0,1},{1,0}};
        // helper(obstacleGrid, 0, 0, vis, dir);
        // return ans;
        int dp[][] = new int[n][m];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == n - 1 && j == m - 1) dp[i][j] = 1;
                else if(i == n - 1){
                    dp[i][j] = dp[i][j + 1];
                }else if(j == m - 1){
                    dp[i][j] = dp[i + 1][j];
                }else{
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];                    
                }
            }
        }
        return dp[0][0];
    }
}