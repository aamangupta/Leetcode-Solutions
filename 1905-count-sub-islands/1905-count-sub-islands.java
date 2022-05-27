class Solution {
    
    // simple dfs in grid2 and checking if ele at that idx is not 0 in grid1, 
    // if it is 0 then change the flag and dont inc. the ans val
    
    public void helper(int [][]arr, int i, int j, int [][]grid1){
        int n = arr.length, m = arr[0].length, box = i * m + j;
        if(grid1[i][j] == 0){
            flag = true;
            return;
        } 
        arr[i][j] = 0;
        int dir[] = {0,1,0,-1,0};
        for(int k = 0; k < 4; k++){
            int ni = i + dir[k], nj = j + dir[k + 1];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && arr[ni][nj] == 1){
                helper(arr, ni, nj, grid1);
            }
        }
    }
    boolean flag = false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    flag = false;
                    helper(grid2, i, j, grid1);
                    if(flag == false) ans++;
                }
            }
        }
        return ans;
    }
}