class Solution {
    public int helper(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0) return 0;
        if(dp[n - 1][m - 1] != -1) return dp[n - 1][m - 1];
        if(str1.charAt(n - 1) == str2.charAt(m - 1)) {
            int sa = 1 + helper(str1, str2, n - 1, m - 1, dp);
            dp[n - 1][m - 1] = sa;
            return sa;
        } else {
            int sa = Math.max(helper(str1, str2, n-1, m, dp), helper(str1, str2, n, m-1, dp));
            dp[n - 1][m - 1] = sa;
            return sa;
        }
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length(), dp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(text1, text2, n, m, dp);
    }
}