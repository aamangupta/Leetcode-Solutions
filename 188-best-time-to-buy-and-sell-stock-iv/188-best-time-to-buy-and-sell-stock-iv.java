class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length, dp[][] = new int[k + 1][n];
        if(n == 0 || n == 1 || k == 0) return 0;
        for(int i = 0; i <= k; i++){
            for(int j = 0; j < n; j++){
                if(i == 0) dp[i][j] = 0;
                else if(j == 0) dp[i][j] = 0;
                else{
                    int maxprofit = dp[i][j - 1];
                    for(int kk = 0; kk < j; kk++){
                        maxprofit = Math.max(maxprofit, prices[j] - prices[kk] + dp[i - 1][kk]);
                    }
                    dp[i][j] = maxprofit;
                }
            }
        }
        return dp[k][n - 1];
    }
}