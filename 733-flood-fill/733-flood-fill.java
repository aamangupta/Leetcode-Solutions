class Solution {
    public class pair{
        int a, b;
        pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public void helper(int [][]arr, int sr, int sc, int ncolor){
        int n = arr.length, m = arr[0].length, color = arr[sr][sc];
        arr[sr][sc] = ncolor;
        for(int k = 0; k < 4; k++){
                int ni = sr + dir[k], nj = sc + dir[k + 1];
                if(ni >= 0 && nj >= 0 && ni < n && nj < m && arr[ni][nj] == color)                 {
                    helper(arr, ni, nj, ncolor);
                }
            }
    }
    int dir[] = {0,1,0,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int n = image.length, m = image[0].length, color = image[sr][sc];
        if(color == newColor) return image; 
        helper(image, sr, sc, newColor);
        return image;
    }
}