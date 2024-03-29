class Solution {
   // TC: O(nm) + O(n*n) = O(n^2)
    public class pair{
        int i;
        int j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        ArrayList<pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    list.add(new pair(i,j));
                }
            }
        }
        
        for(pair p : list){
            int r = p.i, c = p.j;
            for(int i = 0 ; i < n; i++){
                matrix[i][c] = 0;                
            }
            for(int j = 0; j < m; j++){
                matrix[r][j] = 0;
            }
        }
    }
}