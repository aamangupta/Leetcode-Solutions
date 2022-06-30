class Solution {
    public int minMoves2(int[] nums) {
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            long count = 0;
            for(int j = 0; j < nums.length; j++){
                if(i != j) count += Math.abs(nums[i] - nums[j]);
            }
            ans = Math.min(count, ans);
        }
        return (int)ans;
    }
}