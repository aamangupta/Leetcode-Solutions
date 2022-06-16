class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int si = 0, ei = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0, k = i; k < n; j++, k++){
                if(i == 0) dp[j][k] = true;
                else if(i == 1){
                    if(s.charAt(j) == (s.charAt(k))) dp[j][k] = true;
                }
                else{
                    if(dp[j + 1][k - 1] && s.charAt(j) == (s.charAt(k))) {
                        dp[j][k] = true;
                    }
                }
                if(dp[j][k]) {
                    si = j;
                    ei = k;
                }
            }
        }
        return s.substring(si, ei + 1);
    }
}