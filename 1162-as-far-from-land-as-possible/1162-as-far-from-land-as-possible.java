class Solution {
    public class pair{
        int i , j , val;
        pair(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length, dir[] = {0, -1, 0, 1, 0}, ans = 0;
        Queue<pair> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) q.add(new pair(i,j,0));
            }
        }
        while(q.size() > 0){
            // System.out.println("aksj");
            pair rem = q.remove();
            int i = rem.i, j = rem.j, val = rem.val;
            ans = Math.max(ans, val);
            for(int k = 0; k < 4; k++){
                int ni = i + dir[k], nj = j + dir[k + 1];
                if(ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 0){
                    grid[ni][nj] = 1;
                    q.add(new pair(ni, nj, val + 1));
                }
            }
        }
        return ans == 0 ? -1 : ans;
    }
}