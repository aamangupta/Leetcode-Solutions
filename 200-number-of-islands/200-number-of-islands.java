class Solution {
    public void helper(boolean [][]vis, char [][]arr, int r, int c){
        int n = arr.length, m = arr[0].length;
        vis[r][c] = true;
        int dir[] = {0,-1,0,1,0};
        for(int i = 0; i < 4; i++){
            int ni = r + dir[i], nj = c + dir[i + 1];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && vis[ni][nj] == false && arr[ni][nj] == '1'){
                helper(vis, arr, ni, nj);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == false && grid[i][j] == '1') {
                    helper(vis, grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
}