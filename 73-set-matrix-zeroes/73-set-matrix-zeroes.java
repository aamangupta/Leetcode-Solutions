class Solution {
    public class pair{
        int i , j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void setZeroes(int[][] matrix) {
        ArrayList<pair> list = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0) list.add(new pair(i,j));
            }
        }
        for(pair p : list){
            int i = p.i;
            int j = p.j;
            
            for(int k = 0; k < m; k++){
                matrix[i][k] = 0;
            }
            for(int k = 0; k < n; k++){
                matrix[k][j] = 0;
            }
        }
    }
}