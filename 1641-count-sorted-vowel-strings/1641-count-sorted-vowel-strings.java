class Solution {
    public int countVowelStrings(int n) {
        int dp[][] = new int[n][5];
        for(int i = 0; i < n; i++){
            if(i == 0){
                for(int j = 4; j >= 0; j--){
                    dp[i][j] = 1;
                }
            }else{
                dp[i][4] = 1;
                for(int j = 3; j >= 0; j--){
                    dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= 4; i++){ 
            ans += dp[n - 1][i];
        }
        return ans;
    }
}