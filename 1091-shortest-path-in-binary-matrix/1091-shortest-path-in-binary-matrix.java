class Solution {
    public class pair{
        int r;
        int c;
        int val;
        pair(int r, int c, int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(0,0,1));
        int ans = Integer.MAX_VALUE;
        int n = grid.length;
        boolean[][]vis = new boolean[n][n];
        vis[0][0] = true;
        
        while(q.size() > 0){
            pair rem = q.remove();
            int r = rem.r;
            int c = rem.c;
            int val = rem.val;
            if(r == n - 1 && c == n - 1) {
                ans = Math.min(ans, val);
                return ans;
            } 
            
            if(r + 1 >= 0 && r + 1 < n && c >= 0 && c < n && grid[r + 1][c] == 0 && vis[r + 1][c] == false){
                vis[r + 1][c] = true;
                q.add(new pair(r + 1, c, val + 1));
            }
            if(r - 1 >= 0 && r - 1 < n && c >= 0 && c < n && grid[r - 1][c] == 0 && vis[r - 1][c] == false){
                vis[r - 1][c] = true;
                q.add(new pair(r - 1, c, val + 1));
            }
            if(r + 1 >= 0 && r + 1 < n && c - 1 >= 0 && c - 1 < n && grid[r + 1][c - 1] == 0 && vis[r + 1][c - 1] == false){
                vis[r + 1][c - 1] = true;
                q.add(new pair(r + 1, c - 1, val + 1));
            }
            if(r - 1 >= 0 && r - 1 < n && c + 1 >= 0 && c + 1 < n && grid[r - 1][c + 1] == 0 && vis[r - 1][c + 1] == false){
                vis[r - 1][c + 1] = true;
                q.add(new pair(r - 1, c + 1, val + 1));
            }
            if(r >= 0 && r < n && c - 1 >= 0 && c - 1 < n && grid[r][c - 1] == 0 && vis[r][c - 1] == false){
                vis[r][c - 1] = true;
                q.add(new pair(r, c - 1, val + 1));
            }
            if(r >= 0 && r < n && c + 1 >= 0 && c + 1 < n && grid[r][c + 1] == 0 && vis[r][c + 1] == false){
                vis[r][c + 1] = true;
                q.add(new pair(r, c + 1, val + 1));
            }
            if(r - 1 >= 0 && r - 1 < n && c - 1 >= 0 && c - 1 < n && grid[r - 1][c - 1] == 0 && vis[r - 1][c - 1] == false){
                vis[r - 1][c - 1] = true;
                q.add(new pair(r - 1, c - 1, val + 1));
            }
            if(r + 1 >= 0 && r + 1 < n && c + 1 >= 0 && c + 1 < n && grid[r + 1][c + 1] == 0 && vis[r + 1][c + 1] == false){
                vis[r + 1][c + 1] = true;
                q.add(new pair(r + 1, c + 1, val + 1));
            }
        }
        
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}