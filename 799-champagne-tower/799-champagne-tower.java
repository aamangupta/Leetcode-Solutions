class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[101][101];
        arr[0][0] = poured;
        for(int i = 0; i <= query_row; i++){
            for(int j = 0; j <= i; j++){
                if(arr[i][j] > 1.0){
                    double dist = (arr[i][j] - 1.0) / 2.0;
                    arr[i][j] = 1;
                    arr[i + 1][j] += dist;
                    arr[i + 1][j + 1] += dist;
                }
            }
        }
        return arr[query_row][query_glass];
    }
}