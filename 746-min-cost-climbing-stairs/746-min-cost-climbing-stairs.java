class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []dp = new int[n];
        dp[n - 1] = cost[n - 1];
        for(int i = n - 2; i >= 0; i--){

            if(i + 1 >= n) dp[i] = cost[i];
            else if(i + 2 >= n) dp[i] = cost[i];
            else {
                dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
            }
        }
        return Math.min(dp[0], dp[1]);
    }
}