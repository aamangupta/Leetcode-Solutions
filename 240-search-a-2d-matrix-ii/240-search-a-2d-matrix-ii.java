class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int r = 0;
        int c = mat[0].length - 1;
        while(r < mat.length && c >= 0){
            if(mat[r][c] > tar) c--;
            else if(mat[r][c] < tar) r++;
            else return true;
        }
        return false;
    }
}