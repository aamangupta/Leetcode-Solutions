class Solution {
    int ans = 0, c = 0;
    public void helper(int [][]arr, int i, int j){
        c++;
        ans = Math.max(ans, c);
        arr[i][j] = 0;
        int dir[] = {0,1,0,-1,0};
        for(int k = 0; k < 4; k++){
            int ni = i + dir[k], nj = j + dir[k + 1];
            if(ni >= 0 && nj >= 0 && ni < arr.length && nj < arr[0].length && arr[ni][nj] == 1){
                helper(arr, ni, nj);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    c = 0;
                    helper(grid, i, j);
                }
            }
        }
        return ans;
    }
}