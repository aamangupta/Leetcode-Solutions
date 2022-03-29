class Solution {
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean helper(char[][]board, String word, int idx, int i, int j){
        int n = board.length, m = board[0].length;
        if(idx >= word.length()) return true;
        
        char ch = board[i][j];
        board[i][j] = '-';
        for(int d = 0; d < 4; d++){
            int ni = i + dir[d][0], nj = j + dir[d][1];
            
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] != '-' && board[ni][nj] == word.charAt(idx)){
                boolean ans = helper(board, word, idx + 1, ni, nj);
                if(ans) return true;
            }
        }
        board[i][j] = ch;
        return false;
        
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = helper(board, word, 1, i, j);
                    if(ans) return true;
                }    
            }
        }
        return false;
    }
}