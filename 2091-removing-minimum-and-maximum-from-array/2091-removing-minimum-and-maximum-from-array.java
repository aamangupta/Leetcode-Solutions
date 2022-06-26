class Solution {
    public int helper(int min, int max, int []arr){
        int n = arr.length, ans = Integer.MAX_VALUE;
        ans = Math.min(ans, max + 1);
        ans = Math.min(ans, n - min);
        ans = Math.min(ans, n - (max - min - 1));
        return ans;
    }
    public int minimumDeletions(int[] nums) {
        int min = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[min] > nums[i]) {
                min = i;
            }
            if(nums[max] < nums[i]){
                max = i;
            }
        }
        int ans = 0;
        if(min < max) ans = helper(min, max, nums);
        else ans = helper(max, min, nums);
        return ans;
    }
}