class Solution {
    public int helper(int []nums, int n, int[]dp){
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int ans = Math.max(helper(nums, n - 1, dp), nums[n] + helper(nums, n - 2, dp));
        dp[n] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, n - 1, dp);
    }
}