class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
    public int helper(int []nums, int i, int j){
        int no = 0, yes = nums[i];
        for(int k = i + 1; k <= j; k++){
            int nno = Math.max(no, yes);
            int nyes = no + nums[k];
            
            no = nno;
            yes = nyes;
        }
        return Math.max(no, yes);
    }
}