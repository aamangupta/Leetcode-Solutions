class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, dp[] = new int[n];
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            int lim = nums[i], min = Integer.MAX_VALUE;
            for(int j = 1; j + i < n && j <= lim; j++){
                min = Math.min(min, dp[i + j]);
            }
            dp[i] = min;
        }
        if(dp[0] != Integer.MAX_VALUE) return true;
        return false;
    }
}