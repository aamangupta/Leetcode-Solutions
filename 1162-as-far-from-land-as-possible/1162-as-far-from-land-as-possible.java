class Solution {
    public class pair{
        int i , j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length, dir[] = {0, -1, 0, 1, 0}, ans = 0;
        Queue<pair> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) q.add(new pair(i,j));
            }
        }
        while(q.size() > 0){
            // System.out.println("aksj");
            pair rem = q.remove();
            int i = rem.i, j = rem.j;
            for(int k = 0; k < 4; k++){
                int ni = i + dir[k], nj = j + dir[k + 1];
                if(ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 0){
                    grid[ni][nj] = grid[i][j]+1;
                    ans = Math.max(ans, grid[ni][nj]);
                    q.add(new pair(ni, nj));
                }
            }
        }
        return ans-1;
    }
}