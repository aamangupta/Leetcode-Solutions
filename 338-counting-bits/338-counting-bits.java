class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        for(int i = 0; i <= n; i++){
            ans[i] = bits(i, dp);
        }
        return ans;
    }
    public int bits(int n, int dp[]){
        if(n == 1 || n == 0) return n;
        if(dp[n] != -1) return dp[n];
        
        if(n % 2 == 0) {
            dp[n] = bits(n/2, dp);
        }else {
            dp[n] =  1 + bits(n/2, dp);
        }
        return dp[n];
    }
}