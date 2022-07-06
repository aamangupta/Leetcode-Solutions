class Solution {
    public int fib(int n) {
        int []dp = new int[(n + 1)];
        Arrays.fill(dp, -1);
        return (helper(dp, n));
    }
    public int helper(int[]dp, int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(dp[n] != -1) return dp[n];
        
        int a = helper(dp, n - 1) + helper(dp, n - 2);
    
        dp[n] = a;
        return a;
    }
}