class Solution {
    public int findDuplicate(int[] nums) {
        int s = 0, f = 0;
        
        while(true){
            s = nums[s];
            f = nums[nums[f]];
            if(s == f) break;
        }
        s = 0;
        while(true){
            s = nums[s];
            f = nums[f];
            if(s == f) return s;
        }
    }
}