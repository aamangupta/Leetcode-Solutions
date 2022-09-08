class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, i = 0, j = n - 1, k = n - 1;
        int []arr = new int[n];
        while(i <= j){
            int sq1 = nums[i] * nums[i], sq2 = nums[j] * nums[j];
            if(sq1 <= sq2){
                arr[k] = sq2;
                j--;
            }else {
                arr[k] = sq1;
                i++;
            }
            k--;
        }
        return arr;
    }
}