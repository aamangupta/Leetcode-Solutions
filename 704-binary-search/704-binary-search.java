class Solution {
    public int search(int[] nums, int tar) {
        int n = nums.length, i = 0, j = n - 1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == tar) return mid;
            else if(nums[mid] < tar) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }
}