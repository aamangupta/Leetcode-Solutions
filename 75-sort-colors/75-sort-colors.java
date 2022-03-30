class Solution {
    public void swap(int i, int j, int[]nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public void sortColors(int[] nums) {
        int n = nums.length, lo = 0, mid = 0, hi = n - 1;
        while(mid <= hi){
            if(nums[mid] == 0){
                swap(mid, lo, nums);
                mid++;
                lo++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(mid, hi, nums);
                hi--;
            }
        }
    }
}