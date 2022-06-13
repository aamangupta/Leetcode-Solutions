class Solution {
    int ans = Integer.MAX_VALUE;
    public int helper(List<List<Integer>> arr, int i, int j, int sum, int [][]dp){
        if(i == arr.size()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int sum1 = helper(arr, i + 1, j, sum, dp);
        int sum2 = helper(arr, i + 1, j + 1, sum, dp);
        return dp[i][j] = arr.get(i).get(j) + Math.min(sum1, sum2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), j = 0, i = 0, dp[][] = new int[n][n];
        for(int k = 0; k < n; k++){
            Arrays.fill(dp[k], -1);
        }
        helper(triangle, i, j, 0, dp);
        return dp[0][0];
    }
}