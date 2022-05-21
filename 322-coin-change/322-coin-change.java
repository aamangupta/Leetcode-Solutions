class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j : coins){
                if(j <= i){
                    if(dp[i - j] + 1 != 0){
                        min = Math.min(dp[i - j] + 1, min);
                    }
                }
            }
            if(min != Integer.MAX_VALUE) dp[i] = min;
        }
        return dp[amount];
    }
}