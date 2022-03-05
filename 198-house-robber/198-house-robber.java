class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int no = 0, yes = nums[0];
        for(int i = 1; i < n; i++){
            int nno = Math.max(no, yes);
            int nyes = no + nums[i];
            
            no = nno;
            yes = nyes;
        }
        return Math.max(no, yes);
    }
}