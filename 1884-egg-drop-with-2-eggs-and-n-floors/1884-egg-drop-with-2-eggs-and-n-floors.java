class Solution {
    public int twoEggDrop(int n) {
        int dp[][] = new int[3][n + 1];
        for(int i = 0; i <= 2; i++){
            Arrays.fill(dp[i], -1);
        }
        return superEggDropp(2, n, dp);
    }
    public int superEggDropp(int k, int n, int [][]dp){
        if(n == 0 || n == 1) return dp[k][n] = n;
        if(k == 1) return dp[k][n] = n;
        
        if(dp[k][n] != -1) return dp[k][n];
        int min = Integer.MAX_VALUE;
        for(int f = 1; f <= n; f++){
            int l = dp[k - 1][f - 1] != -1 ? dp[k - 1][f - 1] :superEggDropp(k - 1, f - 1, dp);
            int r = dp[k][n - f] != -1 ? dp[k][n - f] :superEggDropp(k, n - f, dp);
            int temp = 1 + Math.max(l, r);
            min = Math.min(temp, min);
        }
        return dp[k][n] = min;
    }
}