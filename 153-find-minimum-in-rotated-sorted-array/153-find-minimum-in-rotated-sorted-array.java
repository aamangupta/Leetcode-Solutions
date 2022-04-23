class Solution {
    public int findMin(int[] nums) {
        //finding that ele around which the array is rotated
        int n = nums.length, lo = 0, hi = n - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mid - 1 >= 0 && mid + 1 < n && nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) return nums[mid];
            if(nums[lo] > nums[mid]) hi = mid - 1;
            else if(nums[mid] > nums[hi]) lo = mid + 1;
            else return nums[lo];
        }
        return nums[lo];
    }
}