class Solution {
    int mod = 1000000007, dir[] = {-1,0,1,0,-1};
    
    public int helper(int n, int m, int max, int str, int stc, int moves, Integer dp[][][]){
        if(moves > max) return 0;
        if(str >= n || stc >= m || str < 0 || stc < 0){
            return 1;
        }
        if(dp[str][stc][moves] != null) {
            return dp[str][stc][moves];
        }
        int val = 0;
        for(int i = 1; i < 5; i++){
            int ni = str + dir[i - 1], nj = stc + dir[i];
            val = (val + helper(n,m,max,ni,nj,moves + 1,dp)) % mod;
        }
        return dp[str][stc][moves] = val;
        
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn){
        Integer dp[][][] = new Integer[m][n][maxMove + 1];
        return helper(m, n, maxMove, startRow, startColumn, 0, dp);
    }
}