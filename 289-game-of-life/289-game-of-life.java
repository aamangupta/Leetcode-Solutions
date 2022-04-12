class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length, ans[][] = new int[n][m];
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int c1 = 0, c0 = 0;
                
                for(int k = 0; k < 8; k++){
                    int ni = i + dir[k][0], nj = j + dir[k][1];
                    
                    if(ni >= 0 && ni < n && nj >= 0 && nj < m){
                        if(board[ni][nj] == 0) c0++;
                        else c1++;
                    }
                }
                
                if(board[i][j] == 0){
                    if(c1 == 3) ans[i][j] = 1;
                }else{
                    if(c1 < 2) ans[i][j] = 0;
                    else if(c1 == 2 || c1 == 3) ans[i][j] = 1;
                    else if(c1 > 3) ans[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}