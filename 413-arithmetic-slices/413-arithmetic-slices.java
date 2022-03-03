class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // using DP
        // dp[i] contains the number of slices ending at index i.
        int n = nums.length;
        if(n < 3) return 0;
        int ans = 0;
        int dp = 0;
        for(int i = 2; i < n; i++){
            if(nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]){
                dp++;
                ans += dp;
            }else dp = 0;
        }
        return ans;
    }
}