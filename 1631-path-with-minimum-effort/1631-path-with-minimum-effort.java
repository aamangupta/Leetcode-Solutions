class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        // pq will contains an array of size = 3
        // a[0] = row, a[1] = col , a[2] = diff
        
        int diff[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(diff[i], Integer.MAX_VALUE);
        }
        diff[0][0] = 0;   
        pq.add(new int[]{0,0,0});

        while(pq.size() > 0){
            int []rem = pq.remove();
            int dir[] = {0,1,0,-1,0};
            int r = rem[0], c = rem[1], d = rem[2];
            if(diff[r][c] < d) continue;
            
            if(r == n-1 && c == m - 1) return d;
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int mindiff = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                    if(diff[nr][nc] > mindiff){
                        diff[nr][nc] = mindiff;
                        pq.add(new int[]{nr, nc, mindiff});
                    }
                }
                
            }
        }
        return 0;
    }
}