class Solution {
    public class pair{
        int a, b;
        pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<pair> q = new ArrayDeque<>();
        
        int dir[] = {0,1,0,-1,0}, n = image.length, m = image[0].length, color = image[sr][sc];
        if(color == newColor) return image; 
        
        q.add(new pair(sr, sc));
        while(q.size() > 0) {
            pair rem = q.remove();
            int i = rem.a, j = rem.b;
            image[i][j] = newColor;
            
            for(int k = 0; k < 4; k++){
                int ni = i + dir[k], nj = j + dir[k + 1];
                if(ni >= 0 && nj >= 0 && ni < n && nj < m && image[ni][nj] == color){
                    q.add(new pair(ni, nj));
                }
            }
        }
        return image;
    }
}