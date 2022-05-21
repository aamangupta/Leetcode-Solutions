class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[] = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j : coins){
                if(j <= i){
                    if(i - j == 0){
                        min = Math.min(1, min);
                        break;
                    }else{
                        if(dp[i - j] > 0){
                            min = Math.min(dp[i - j] + 1, min);
                        }
                    }
                }else break;
            }
            if(min != Integer.MAX_VALUE) dp[i] = min;
            else dp[i] = -1;
        }
        return dp[amount];
    }
}