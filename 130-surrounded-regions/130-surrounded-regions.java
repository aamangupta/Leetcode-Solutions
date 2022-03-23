class Solution {
    int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    public void dfs(boolean [][]vis, char [][]board, int i, int j, HashSet<Integer> set){
        int n = board.length, m = board[0].length;
        set.add(i * m + j);
        vis[i][j] = true;
        for(int k = 0; k < 4; k++){
            int ni = dir[k][0] + i;
            int nj = dir[k][1] + j;
            
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] == 'O' && set.contains(ni * m + nj) == false){
                dfs(vis, board, ni, nj, set);
            }
        }
    }
    public void solve(char[][] board) {
        HashSet<Integer> set = new HashSet<>();
        int n = board.length, m = board[0].length;
       
        boolean[][]vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && board[i][j] == 'O' && set.contains(i * m + j) == false){
                    dfs(vis, board, i, j, set);
                }
                else if(j == m-1 && board[i][j] == 'O' && set.contains(i * m + j) == false){
                    dfs(vis, board, i, j, set);
                }
                else if(j == 0 && board[i][j] == 'O' && set.contains(i * m + j) == false){
                    dfs(vis, board, i, j, set);
                }
                else if(i == n-1 && board[i][j] == 'O' && set.contains(i * m + j) == false){
                    dfs(vis, board, i, j, set);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int box = i * m + j;
                if(set.contains(box) == false) board[i][j] = 'X';
            }
        }
    }
}