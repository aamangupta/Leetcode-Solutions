class Solution {
    public class pair{
        int i, j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int dir[] = {1,0,-1,0,1};
        int n = mat.length;
        int m = mat[0].length;
        Queue<pair> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0) q.add(new pair(i,j));
                else mat[i][j] = -1;
            }
        }
        
        while(q.size() > 0){
            pair rem = q.remove();
            int r = rem.i;
            int c = rem.j;
            
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == -1){
                    q.add(new pair(nr, nc));
                    mat[nr][nc] = mat[r][c] + 1;
                }
            }
        }
        return mat;
    }
}