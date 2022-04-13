class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int sr = 0;
        int sc = 0;
        int er = mat.length;
        int ec = mat[0].length;
        int count = 1;
        int max = (er * ec);
        er -= 1;
        ec -= 1;
        while(count <= max){
            // top
            for(int i = sc; i <= ec && count <= max; i++){
                mat[sr][i] = count;
                count++;
            }
            sr++;
            //right 
            for(int i = sr; i <= er && count <= max; i++){
                mat[i][ec] = count;
                count++;
            }
            ec--;
            //bottm
            for(int i = ec; i >= sc && count <= max; i--){
                mat[er][i] = count;
                count++;
            }
            er--;
            //left
            for(int i = er; i >= sr && count <= max; i--){
                mat[i][sc] = count;
                count++;
            }
            sc++;
        }
        return mat;
    }
}