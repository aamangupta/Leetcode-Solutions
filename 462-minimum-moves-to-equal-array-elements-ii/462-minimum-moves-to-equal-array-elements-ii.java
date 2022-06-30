class Solution {
    public int minMoves2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int med = nums[nums.length/2];
        for(int i : nums){
            ans += Math.abs(i - med);
        }
        return ans;
    }
}